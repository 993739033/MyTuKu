package com.scode.mytuku;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageLoadUtils imageLoadUtils;
    ProgressDialog progressdialog;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, "total:"+imageLoadUtils.totalsize, Toast.LENGTH_SHORT).show();
            progressdialog.dismiss();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLoadUtils =new ImageLoadUtils();
        progressdialog=ProgressDialog.show(this,null,"正在加载请稍后。。");
        imageLoadUtils.getImages(this,handler);


    }
}
