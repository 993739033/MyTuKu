package com.scode.mytuku.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scode.mytuku.R;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class main_viewholder extends RecyclerView.ViewHolder {
    public ImageView cardview;
    public TextView dirname;
    public TextView pathname;
    public TextView pathsize;
    public View view;



    public main_viewholder(View itemView) {
        super(itemView);
        cardview = (ImageView) itemView.findViewById(R.id.recy_image);
        dirname = (TextView) itemView.findViewById(R.id.dirname);
        pathname = (TextView) itemView.findViewById(R.id.pathname);
        pathsize = (TextView) itemView.findViewById(R.id.pathsize);
        view=itemView;
    }
}
