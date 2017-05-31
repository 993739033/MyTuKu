package com.scode.mytuku.Activitys;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scode.mytuku.Adapter.Tuku_dir_item_adapter;
import com.scode.mytuku.JavaBean.ImageFloder;
import com.scode.mytuku.R;
import com.scode.mytuku.Utils.ImageLoadUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class dir_images extends AppCompatActivity {
    List<File> images;
    RecyclerView recyclerView;

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
        Tuku_dir_item_adapter adapter = new Tuku_dir_item_adapter(images);
        recyclerView.setAdapter(adapter);

    }
}
