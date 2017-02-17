package com.oceandemy.model;

/**
 * Created by duand on 08/02/2017.
 */

public class Music {
    private String maBaiHat;
    private String tenBaiHat;
    private String tenCaSy;
    private boolean thich;

    public String getMaBaiHat() {
        return maBaiHat;
    }

    public void setMaBaiHat(String maBaiHat) {
        this.maBaiHat = maBaiHat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenCaSy() {
        return tenCaSy;
    }

    public void setTenCaSy(String tenCaSy) {
        this.tenCaSy = tenCaSy;
    }

    public boolean isThich() {
        return thich;
    }

    public void setThich(boolean thich) {
        this.thich = thich;
    }

    public Music(String maBaiHat, String tenBaiHat, String tenCaSy, boolean thich) {
        this.maBaiHat = maBaiHat;
        this.tenBaiHat = tenBaiHat;
        this.tenCaSy = tenCaSy;
        this.thich = thich;
    }

    public Music() {
    }
}
