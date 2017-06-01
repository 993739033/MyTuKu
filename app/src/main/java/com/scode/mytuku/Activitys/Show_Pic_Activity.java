package com.scode.mytuku.Activitys;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.scode.mytuku.Adapter.Tuku_pic_viewpage_adapter;
import com.scode.mytuku.CustomView.MyPopupWindow;
import com.scode.mytuku.R;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class Show_Pic_Activity extends AppCompatActivity {
    private List<String> paths;
    private List<File> pics;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__pic_);
        initView();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){

        }
    }

    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        String picpath = getIntent().getStringExtra("picpath");//接收被点击的view的path
        String parentpath = new File(picpath).getParent();
        File[] files=new File(parentpath).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".jpeg"));
            }
        });
        pics = Arrays.asList(files);

        int index= pics.indexOf(new File(picpath));
        Tuku_pic_viewpage_adapter adpater = new Tuku_pic_viewpage_adapter(pics);
        viewPager.setAdapter(adpater);
        viewPager.setCurrentItem(index,false);
        viewPager.setOffscreenPageLimit(3);

    }


}
