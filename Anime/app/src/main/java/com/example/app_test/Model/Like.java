package com.example.app_test.Model;

public class Like  {
    private int Id;
    private String Title,Category,Info;


    public Like(int id, String title, String category, String info) {
        Id = id;
        Title = title;
        Category = category;
        Info = info;
    }

    public Like() {
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
