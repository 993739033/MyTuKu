package com.scode.mytuku.CustomView;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.scode.mytuku.R;

/**
 * Created by 知らないのセカイ on 2017/6/1.
 */

public class MyPopupWindow extends PopupWindow {

    //自定以viewpage中的popupwindow
    public MyPopupWindow(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_view, null);
       this.setContentView(view);
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        Button delete = (Button) view.findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "delete be clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Show(){
        this.showAtLocation(getContentView(), Gravity.BOTTOM, 0, 0);
    }

}
