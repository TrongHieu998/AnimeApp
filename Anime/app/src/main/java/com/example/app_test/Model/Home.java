package com.example.app_test.Model;

public class Home {
    private int anh;
    private String tap;

    public Home() {
    }

    public Home(int anh, String tap) {
        this.anh = anh;
        this.tap = tap;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTap() {
        return tap;
    }

    public void setTap(String tap) {
        this.tap = tap;
    }
}
