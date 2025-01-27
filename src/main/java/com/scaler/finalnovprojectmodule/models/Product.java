//package com.scaler.finalnovprojectmodule.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.ManyToOne;
//
//import java.util.Date;
//
//
////@Entity
//
////public class Product extends BaseModel{
////    public Product() {
////        super();
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public Product(Long id, Date createdAt, Date updatedAt, boolean isDeleted) {
////        super(id, createdAt, updatedAt, isDeleted);
////    }
////
////    public Product(Long id, Date createdAt, Date updatedAt, boolean isDeleted, String title, String description, Double price, String imageUrl, Category category) {
////        super(id, createdAt, updatedAt, isDeleted);
////        this.title = title;
////        this.description = description;
////        this.price = price;
////        this.imageUrl = imageUrl;
////        this.category = category;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public String getDescription() {
////        return description;
////    }
////
////    public void setDescription(String description) {
////        this.description = description;
////    }
////
////    public Double getPrice() {
////        return price;
////    }
////
////    public void setPrice(Double price) {
////        this.price = price;
////    }
////
////    public String getImageUrl() {
////        return imageUrl;
////    }
////
////    public void setImageUrl(String imageUrl) {
////        this.imageUrl = imageUrl;
////    }
////
////    public Category getCategory() {
////        return category;
////    }
////
////    public void setCategory(Category category) {
////        this.category = category;
////    }
////
////@Getter
////@Setter
////@AllArgsConstructor
////@NoArgsConstructor
//
//
//
//@Entity
//public class Product extends BaseModel {
//    private String title;
//    private String description;
//    private Double price;
//    private String imageUrl;
//    @ManyToOne
//    private Category category;
//
//
//    public Product(long id, String title, String description, Double price, String imageUrl, Category category) {
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.imageUrl = imageUrl;
//        this.category = category;
//    }
//
//    public Product(Long id, Date createdAt, Date updatedAt, boolean isDeleted, String title, String description, Category category, String imageUrl, Double price) {
//        // super(id, createdAt, updatedAt, isDeleted);
//        this.title = title;
//        this.description = description;
//        this.category = category;
//        this.imageUrl = imageUrl;
//        this.price = price;
//    }
//
//    // ALl args constructor
//
//    public Product(String title, String description, Category category, String imageUrl, Double price) {
//        this.title = title;
//        this.description = description;
//        this.category = category;
//        this.imageUrl = imageUrl;
//        this.price = price;
//    }
//
//    public Product(Long id, Date createdAt, Date updatedAt, boolean isDeleted) {
//        super(id, createdAt, updatedAt, isDeleted);
//    }
//
//    public Product() {
//        super();
//    }
//
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", imageUrl='" + imageUrl + '\'' +
//                ", category=" + category +
//                '}';
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public String getDescription() {
////        return description;
////    }
////
////    public void setDescription(String description) {
////        this.description = description;
////    }
////
////    public Double getPrice() {
////        return price;
////    }
////
////    public void setPrice(Double price) {
////        this.price = price;
////    }
////
////    public String getImageUrl() {
////        return imageUrl;
////    }
////
////    public void setImageUrl(String imageUrl) {
////        this.imageUrl = imageUrl;
////    }
////
////    public Category getCategory() {
////        return category;
//
////    public void setCategory(Category category) {
////        this.category = category;
////    }
//}
