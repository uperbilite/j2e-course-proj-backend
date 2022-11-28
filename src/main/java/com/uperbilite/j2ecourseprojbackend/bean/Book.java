package com.uperbilite.j2ecourseprojbackend.bean;

public class Book {
    private int id;
    private String name;
    private int price;
    private String description;
    private String coverURL;

    public Book() {
        this.id = 0;
        this.name = "";
        this.price = 0;
        this.description = "";
        this.coverURL = "";
    }

    public Book(int id, String name, int price, String description, String coverURL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.coverURL = coverURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }
}
