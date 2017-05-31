package com.scode.mytuku.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.scode.mytuku.R;

import java.io.File;
import java.util.List;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class Tuku_dir_item_adapter extends RecyclerView.Adapter<dir_image_viewholder> {
    private List<File> imagePaths;
    private Context mcontext;

    public Tuku_dir_item_adapter(List<File> imagePaths) {
        this.imagePaths=imagePaths;
    }

    @Override
    public dir_image_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dir_recy_item, null);
        mcontext=parent.getContext();
        return new dir_image_viewholder(view);
    }

    @Override
    public void onBindViewHolder(dir_image_viewholder holder, int position) {
        File image = imagePaths.get(position);
        Glide.with(mcontext).load(image).into(holder.cardview);
    }

    @Override
    public int getItemCount() {
        return imagePaths.size();
    }
}
