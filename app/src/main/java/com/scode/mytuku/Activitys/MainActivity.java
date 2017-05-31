package com.scode.mytuku.Activitys;

import android.app.ProgressDialog;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.scode.mytuku.Adapter.Tuku_main_rec_adapter;
import com.scode.mytuku.R;
import com.scode.mytuku.Utils.ImageLoadUtils;

public class MainActivity extends AppCompatActivity {
    ImageLoadUtils imageLoadUtils;
    ProgressDialog progressdialog;
    RecyclerView mrec;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, "total:"+imageLoadUtils.totalsize, Toast.LENGTH_SHORT).show();
            progressdialog.dismiss();
            initView();
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
    private void initView() {
        mrec = (RecyclerView) findViewById(R.id.RV_dirs);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mrec.setLayoutManager(manager);
        Tuku_main_rec_adapter adapter=new Tuku_main_rec_adapter(imageLoadUtils.imagefloders);
        mrec.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top=10;
                outRect.bottom=10;
            }
        });
        mrec.setAdapter(adapter);
    }
}
