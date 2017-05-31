package com.scode.mytuku.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scode.mytuku.R;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class dir_image_viewholder extends RecyclerView.ViewHolder {
    public ImageView cardview;

    public dir_image_viewholder(View itemView) {
        super(itemView);
        cardview = (ImageView) itemView.findViewById(R.id.recy_dir_image);
    }
}
