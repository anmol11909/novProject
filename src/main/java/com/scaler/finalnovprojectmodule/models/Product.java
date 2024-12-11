package com.scaler.finalnovprojectmodule.models;


public class Product {
    private long id;
    private String title;
    private String description;;
    private  Double price;
    private String imageUrl;
    private Category category;

    public Product() {
    }

    public Product(String description, Double price, String imageUrl, long id, String title, Category category) {
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}