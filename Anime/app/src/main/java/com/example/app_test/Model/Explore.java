package com.example.app_test.Model;

import java.util.ArrayList;

public class Explore {
    String ten,mota,tacgia,luotxem,luotthich,danhgia;
    int anh;

    public Explore() {
    }

    public Explore(int anh) {
        this.anh = anh;
    }

    public Explore(String ten, String mota, String tacgia, String luotxem, String luotthich, String danhgia, int anh) {
        this.ten = ten;
        this.mota = mota;
        this.tacgia = tacgia;
        this.luotxem = luotxem;
        this.luotthich = luotthich;
        this.danhgia = danhgia;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getLuotxem() {
        return luotxem;
    }

    public void setLuotxem(String luotxem) {
        this.luotxem = luotxem;
    }

    public String getLuotthich() {
        return luotthich;
    }

    public void setLuotthich(String luotthich) {
        this.luotthich = luotthich;
    }

    public String getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(String danhgia) {
        this.danhgia = danhgia;
    }
}
