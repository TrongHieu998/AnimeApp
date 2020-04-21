package com.example.app_test.Model;

public class Library {
    private String ten;
    private String tap;
    private int anh;
    public Library() {
    }

    public Library(String ten, int anh) {
        this.ten = ten;
        this.anh = anh;
    }

    public Library(String ten, String tap, int anh) {
        this.ten = ten;
        this.tap = tap;
        this.anh = anh;
    }

    public String getTap() {
        return tap;
    }

    public void setTap(String tap) {
        this.tap = tap;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
