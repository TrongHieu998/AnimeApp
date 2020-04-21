package com.example.app_test.Model;

public class Popular {
    String img,title,genres,lastest,type,plot,released,status,orther,detailUrl;

    public Popular() {
    }


    public Popular(String img, String title, String genres, String lastest, String detailUrl) {
        this.img = img;
        this.title = title;
        this.genres = genres;
        this.lastest = lastest;
        this.detailUrl = detailUrl;
    }

    public Popular(String img, String title, String genres, String lastest, String type, String plot, String released, String status, String orther) {
        this.img = img;
        this.title = title;
        this.genres = genres;
        this.lastest = lastest;
        this.type = type;
        this.plot = plot;
        this.released = released;
        this.status = status;
        this.orther = orther;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLastest() {
        return lastest;
    }

    public void setLastest(String lastest) {
        this.lastest = lastest;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
    /// them

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrther() {
        return orther;
    }

    public void setOrther(String orther) {
        this.orther = orther;
    }
}
