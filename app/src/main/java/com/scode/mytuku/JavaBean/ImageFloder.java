package com.scode.mytuku.JavaBean;

/**
 * Created by 知らないのセカイ on 2017/5/30.
 */

public class ImageFloder {
    private String dir;//文件夹路径
    private String name;//文件夹名称
    private String count;//文件夹中的数量
    private String firstimagepath;//文件夹中第一张图片

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
        int lastIndexOf = dir.lastIndexOf("/");
        name = dir.substring(lastIndexOf);
    }
    public String getName(){return name;}

    public String getCount() {
        return count;
    }
     public void setCount(String count){
        this.count = count;
    }

    public String getFirstimagepath() {
        return firstimagepath;
    }

    public void setFirstimagepath(String firstimagepath) {
        this.firstimagepath = firstimagepath;
    }
}
