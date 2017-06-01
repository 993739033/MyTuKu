package com.scode.mytuku.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.scode.mytuku.R;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class dir_image_viewholder extends RecyclerView.ViewHolder {
    public ImageView imageview;
    public ImageView checkview;
    public CardView cardview;

    public dir_image_viewholder(View view) {
        super(view);
        this.imageview = (ImageView) view.findViewById(R.id.recy_dir_image);
        checkview = (ImageView) view.findViewById(R.id.recy_dir_check_image);
        cardview = (CardView) view.findViewById(R.id.recy_cardview);
    }
}
