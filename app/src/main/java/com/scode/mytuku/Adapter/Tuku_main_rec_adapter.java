package com.scode.mytuku.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.scode.mytuku.JavaBean.ImageFloder;
import com.scode.mytuku.R;
import com.scode.mytuku.Activitys.dir_images;

import java.util.List;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class Tuku_main_rec_adapter extends RecyclerView.Adapter<main_viewholder> {
    private List<ImageFloder> imageFloders;
    private Context mcontext;
    private String betouchedpath;

    public Tuku_main_rec_adapter(List<ImageFloder> imageFloders) {
        this.imageFloders = imageFloders;
    }

    @Override
    public main_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_item, null);

        mcontext=parent.getContext();
        return new main_viewholder(view);

    }

    @Override
    public void onBindViewHolder(main_viewholder holder, int position) {
        final ImageFloder imageFloder = imageFloders.get(position);
        Glide.with(mcontext).load(imageFloder.getFirstimagepath()).into(holder.cardview);
        holder.pathsize.setText(imageFloder.getCount());
        holder.pathname.setText(imageFloder.getName());
        holder.dirname.setText(imageFloder.getDir());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i= v.getId();
                Intent mintent = new Intent(mcontext,dir_images.class);
                mintent.putExtra("position",imageFloder.getDir());
                mcontext.startActivity(mintent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageFloders.size();
    }
}
