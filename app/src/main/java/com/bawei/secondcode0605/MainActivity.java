package com.bawei.secondcode0605;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //打开默认二维码扫描界面
    public void alert(View view){
        Intent intent=new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //处理二维码扫描结果
        if (requestCode==0){
            //处理扫描结果
            if (null!=data){
                Bundle bundle = data.getExtras();
                if (bundle==null){
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this,"解析结果:"+result,Toast.LENGTH_LONG).show();
                }else if (bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_FAILED){
                    Toast.makeText(this,"解析二维码失败",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
