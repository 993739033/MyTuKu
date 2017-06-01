package com.scode.mytuku.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.scode.mytuku.Activitys.Show_Pic_Activity;
import com.scode.mytuku.R;

import java.io.File;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class Tuku_dir_item_adapter extends RecyclerView.Adapter<dir_image_viewholder> {
    private List<File> imagePaths;
    private Context mcontext;
    public HashSet<String> hashSet=new HashSet<>();
    public Boolean isbetouched = false;

    public Tuku_dir_item_adapter(List<File> imagePaths) {
        this.imagePaths = imagePaths;
    }

    @Override
    public dir_image_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dir_recy_item, null);
        mcontext = parent.getContext();
        return new dir_image_viewholder(view);
    }

    @Override
    public void onBindViewHolder(final dir_image_viewholder holder, int position) {
        final File image = imagePaths.get(position);
        if (isbetouched) {
            holder.checkview.setVisibility(View.VISIBLE);
            if (hashSet.contains(image.getAbsolutePath())){
                holder.checkview.setImageResource(R.drawable.check_box_2);
                holder.imageview.setColorFilter(R.color.colorbeselected);
            }else{
                holder.checkview.setImageResource(R.drawable.check_box_1);
               holder.imageview.setColorFilter(null);
            }
        }
        else{
            if (holder.checkview.VISIBLE==View.VISIBLE) {
                holder.checkview.setVisibility(View.GONE);
            }
        }
        Glide.with(mcontext).load(image).asBitmap().placeholder(R.drawable.question).error(R.drawable.error).into(holder.imageview);
        //为图片设置长按事件
        holder.cardview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (isbetouched) {
                    //当已经选中或者已经有长按事件触发时
                    if (!hashSet.contains(image.getAbsolutePath())) {
                        holder.checkview.setImageResource(R.drawable.check_box_2);
                        hashSet.add(image.getAbsolutePath());
                        holder.imageview.setColorFilter(R.color.colorbeselected);

                    }else{
                        hashSet.remove(image.getAbsolutePath());
                        holder.checkview.setImageResource(R.drawable.check_box_1);
                        holder.imageview.setColorFilter(null);
                    }

                } else {
                    //当还未有长按事件触发时
                    isbetouched = true;
                    holder.checkview.setImageResource(R.drawable.check_box_2);
                    notifyDataSetChanged();
                    hashSet.add(image.getAbsolutePath());
                    holder.imageview.setColorFilter(R.color.colorbeselected);
                }
                return true;
            }
        });

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isbetouched){
                    if (!hashSet.contains(image.getAbsolutePath())) {
                        holder.checkview.setImageResource(R.drawable.check_box_2);
                        holder.imageview.setColorFilter(R.color.colorbeselected);
                        hashSet.add(image.getAbsolutePath());

                    }else{
                        hashSet.remove(image.getAbsolutePath());
                        holder.checkview.setImageResource(R.drawable.check_box_1);
                        holder.imageview.setColorFilter(null);
                    }
                }else{
                    //在这里进行跳转到具体显示的viewpage
                    Intent intent = new Intent(mcontext, Show_Pic_Activity.class);
                    intent.putExtra("picpath", image.getAbsolutePath());
                    mcontext.startActivity(intent);


                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return imagePaths.size();
    }
}
