package com.scaler.finalnovprojectmodule.Dto;

import com.scaler.finalnovprojectmodule.models.Category;
import com.scaler.finalnovprojectmodule.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor



public class fakeStoreProductDto {


    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

    public fakeStoreProductDto() {
    }

    public fakeStoreProductDto(Long id, String title, Double price, String description, String category, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public Product getProduct(){
        // mapping fakestore DTo  to our Product
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setTitle(category);
        product.setCategory(cat);

        return product;
    }

    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
