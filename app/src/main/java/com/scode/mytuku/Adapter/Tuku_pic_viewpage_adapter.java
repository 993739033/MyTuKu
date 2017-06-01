package com.scode.mytuku.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.scode.mytuku.CustomView.MyPopupWindow;
import com.scode.mytuku.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 知らないのセカイ on 2017/5/31.
 */

public class Tuku_pic_viewpage_adapter extends PagerAdapter {
    private List<File> pics = new ArrayList<>();

    public Tuku_pic_viewpage_adapter(List<File> images) {
        this.pics = images;
    }

    @Override
    public int getCount() {
        return pics.size();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.pic_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.pic_image);
        Glide.with(container.getContext()).load(pics.get(position)).into(imageView);
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyPopupWindow(v.getContext()).Show();
            }
        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }



}
