package com.project.s1s1s1.assethelper;

import android.graphics.Bitmap;

public class DataModel {
    private String imgDes;
    private Bitmap image;

    public DataModel(String imgDes, Bitmap image) {
        this.imgDes = imgDes;
        this.image = image;
    }


    public String getImgDes() {
        return imgDes;
    }

    public void setImgDes(String imgDes) {
        this.imgDes = imgDes;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
