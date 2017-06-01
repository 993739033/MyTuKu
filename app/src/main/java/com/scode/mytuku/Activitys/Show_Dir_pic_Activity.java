package com.scode.mytuku.Activitys;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;

import com.scode.mytuku.Adapter.Tuku_dir_item_adapter;
import com.scode.mytuku.JavaBean.ImageFloder;
import com.scode.mytuku.R;
import com.scode.mytuku.Utils.ImageLoadUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class Show_Dir_pic_Activity extends AppCompatActivity {
    List<File> images;
    RecyclerView recyclerView;
    Tuku_dir_item_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dir_images);
        String path = getIntent().getStringExtra("position");
        File[] files=new File(path).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".jpeg"));
            }
        });
        images = Arrays.asList(files);
        recyclerView = (RecyclerView) findViewById(R.id.RV_dir_images);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top=3;
                outRect.bottom=3;
                outRect.left=3;
                outRect.right=3;
            }
        });
         adapter= new Tuku_dir_item_adapter(images);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK&&adapter.isbetouched) {
            adapter.isbetouched=false;
            adapter.hashSet.clear();
            adapter.notifyDataSetChanged();
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }

}
