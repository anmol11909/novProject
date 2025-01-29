//package com.scaler.finalnovprojectmodule.models;
////
////import jakarta.persistence.Entity;
////import org.springframework.boot.autoconfigure.domain.EntityScan;
////import jakarta.persistence.MappedSuperclass;
////import lombok.AllArgsConstructor;
////import lombok.Getter;
////import lombok.NoArgsConstructor;
////import lombok.Setter;
////
////import java.util.Date;
////import java.util.Locale;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.stripe.model.Product;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.OneToMany;
//import com.scaler.finalnovprojectmodule.models.Product;
//
//
//
//
//import java.util.List;
//
//////
//////@Getter
//////@Setter
//////@AllArgsConstructor
//////@NoArgsConstructor
////
////
////
//@Entity
//public class Category extends BaseModel {
//    private String catTitle;
//
//    public Category() {
//    }
//
//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//@JsonManagedReference
//private List<Product> products;
////
//    public Category(long id, String name) {
//        this.id = id;
//        this.catTitle = name;
//    }
//
//    public void setCatTitle(String catTitle) {
//        this.catTitle = catTitle;
//    }
//
//    public List<Product> getProducts() {
//    return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    public String getCatTitle() {
//        return null;
//    }
//}
//}
//
//
////
////    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted, String title) {
////        super(id, createdAt, updatedAt, isDeleted);
////        this.title = title;
////    }
////
////    public Category(String title) {
////        this.title = title;
////    }
////
////
////
////
////
////    public String getCatTitle() {
////        return catTitle;
////    }
//
////    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted) {
////        super(id, createdAt, updatedAt, isDeleted);
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////}
////
////    public Category(String title) {
////        this.title = title;
////    }
////
////    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted) {
////        super(id, createdAt, updatedAt, isDeleted);
////    }
////
////    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted, String title) {
////        super(id, createdAt, updatedAt, isDeleted);
////        this.title = title;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    private String title;
////

package com.scaler.finalnovprojectmodule.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scaler.finalnovprojectmodule.models.BaseModel;
import com.scaler.finalnovprojectmodule.models.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
public class Category extends BaseModel {
    private String catTitle;
    public Category() {
    }


    @OneToMany (mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;

    public Category(long id, String name) {
        this.id = id;
        this.catTitle = name;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}