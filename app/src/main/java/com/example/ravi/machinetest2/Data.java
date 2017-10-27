package com.example.ravi.machinetest2;

import java.io.Serializable;

/**
 * Created by ravi on 26/10/17.
 */

public class Data implements Serializable {

    String mTitle,mDescription,SImg,MImg,LImg;



    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getSImg() {
        return SImg;
    }

    public void setSImg(String SImg) {
        this.SImg = SImg;
    }

    public String getMImg() {
        return MImg;
    }

    public void setMImg(String MImg) {
        this.MImg = MImg;
    }

    public String getLImg() {
        return LImg;
    }

    public void setLImg(String LImg) {
        this.LImg = LImg;
    }
}
