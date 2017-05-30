package com.scode.mytuku;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class ImageLoadUtils {
    public ProgressDialog progressDialog;
    String firstImage=null;
    HashSet<String> mdirset = new HashSet<>();//声明一个hashset用于判断是否已经扫描过此文件夹
    public int totalsize;//记录所有文件夹中的图片总数
    public List<ImageFloder> imagefloders = new ArrayList<>();//用于返回所有的imagefloder对象
    File mImgDir=null;//用于确定包含图片最多的文件夹
    int mPicCount=0;//用于比较最多图片文件夹
    boolean iscomplete=false;



    //判断是否有内存卡插入
    public void getImages(final Context context, final Handler mhandler){
        //因为我手机没内存卡这里就不做判断
//        if (!Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)) {
//            Toast.makeText(context, "未检测到内存卡，请确认后重试！", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        progressDialog = ProgressDialog.show(context, null, "正在加载中请稍后。。。");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //通过ContentResolver来查询内存卡中所有的jpeg，png格式图片
                Uri imageuri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;//获取获取手机内部的图片信息的uri 内存卡的图片uri为 external 手机虽然没插内存但是还是作为外部储存
                ContentResolver resolver=context.getContentResolver();
                Cursor mcursor = resolver.query(imageuri, null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?"
                        , new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED);

                while(mcursor.moveToNext()){
                    //查询所有图片的path
                    String imagepath = mcursor.getString(mcursor.getColumnIndex(MediaStore.Images.Media.DATA));

                    //声明一个imagefloder对象
                    ImageFloder imagefloder=null;
                    if (firstImage==null){
                        firstImage=imagepath;
                    }
                    //通过file返回file的父类文件夹的路径
                  File parentDir =new File(imagepath).getParentFile();//获取parentpath的路径
                    if (parentDir == null) {//没有父类路径？？在内存卡中还会没有父类路径
                        continue;
                    }
                    if (mdirset.contains(parentDir)){
                        continue;
                    }else{
                        imagefloder=new ImageFloder();//当此文件夹为新的文件再进行添加
                        imagefloder.setFirstimagepath(imagepath);//设置第一张图片
                        imagefloder.setDir(parentDir.getAbsolutePath());//设置该文件夹
                        //过滤文件夹中的图片，并返回所有图片的长度
                        int piccount=parentDir.list(new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                return (name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".jpeg"));
                            }
                        }).length;
                        totalsize+=piccount;
                        imagefloder.setCount(piccount);
                        if(piccount>mPicCount){
                            mPicCount=piccount;
                            mImgDir = parentDir;
                        }
                    }
                }
                mcursor.close();
                //将hashset设置为null  辅助的set释放掉
                mdirset=null;
                iscomplete=true;

//                progressDialog.dismiss();//完成取消等待
//                Handler mhandler =new Handler(Looper.getMainLooper());//创建主线程中的handler
//                mhandler.sendEmptyMessage(0);
                mhandler.sendEmptyMessage(0);
            }
        }).start();

    }
}
