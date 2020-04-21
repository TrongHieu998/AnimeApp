package com.example.app_test.Model;

public class Jsoup_model {
    String img,ten,tap,detailUrl;

    public Jsoup_model() {
    }

    public Jsoup_model(String img, String ten, String tap, String detailUrl) {
        this.img = img;
        this.ten = ten;
        this.tap = tap;
        this.detailUrl = detailUrl;
    }

    public Jsoup_model(String img, String ten, String tap) {
        this.img = img;
        this.ten = ten;
        this.tap = tap;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTap() {
        return tap;
    }

    public void setTap(String tap) {
        this.tap = tap;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
}
