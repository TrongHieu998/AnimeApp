package com.example.app_test.Model;

public class Detail_model {
    String title,minutes;

    public Detail_model() {
    }

    public Detail_model(String title, String minutes) {
        this.title = title;
        this.minutes = minutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }
}
