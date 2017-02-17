package com.oceandemy.model;

/**
 * Created by duand on 06/02/2017.
 */

public class NhanVien {
    private String tenNhanVien;
    private String thuBatDauCongTac;
    private int soNgayCongTac;

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getThuBatDauCongTac() {
        return thuBatDauCongTac;
    }

    public void setThuBatDauCongTac(String thuBatDauCongTac) {
        this.thuBatDauCongTac = thuBatDauCongTac;
    }

    public int getSoNgayCongTac() {
        return soNgayCongTac;
    }

    public void setSoNgayCongTac(int soNgayCongTac) {
        this.soNgayCongTac = soNgayCongTac;
    }

    public NhanVien(String tenNhanVien, String thuBatDauCongTac, int soNgayCongTac) {
        this.tenNhanVien = tenNhanVien;
        this.thuBatDauCongTac = thuBatDauCongTac;
        this.soNgayCongTac = soNgayCongTac;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return this.tenNhanVien + " bắt đầu công tác vào " + this.thuBatDauCongTac +
                "\nSố ngày công tác dự kiến "+ this.soNgayCongTac;
    }
}
