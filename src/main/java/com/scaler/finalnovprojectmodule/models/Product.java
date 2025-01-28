package com.scaler.finalnovprojectmodule.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.scaler.finalnovprojectmodule.models.BaseModel;
import com.scaler.finalnovprojectmodule.models.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


//
//import jakarta.persistence.Entity;
//import jakarta.persistence.ManyToOne;
//
//import java.util.Date;
//
//
@Entity

public class Product extends BaseModel {
    private String title;
    private String description;
    @ManyToOne
    @JsonBackReference

    private Category category;
    private double price;
    private String image_url;

    public Product() {
    }


    public Product(long productId, String title, String description, Category category, double price, String image_url) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.image_url = image_url;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

