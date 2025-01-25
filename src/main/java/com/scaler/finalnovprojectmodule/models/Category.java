package com.scaler.finalnovprojectmodule.models;

import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Locale;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor



@Entity
public class Category extends BaseModel {
    private String catTitle;

    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted, String title) {
        super(id, createdAt, updatedAt, isDeleted);
        this.title = title;
    }

    public Category(String title) {
        this.title = title;
    }

    public Category() {
    }

    public Category(Long id, String name){
        this.id = id;
        this.catTitle = name;
    }

    public String getCatTitle() {
        return catTitle;
    }

//    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted) {
//        super(id, createdAt, updatedAt, isDeleted);
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//}
//
//    public Category(String title) {
//        this.title = title;
//    }
//
//    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted) {
//        super(id, createdAt, updatedAt, isDeleted);
//    }
//
//    public Category(Long id, Date createdAt, Date updatedAt, boolean isDeleted, String title) {
//        super(id, createdAt, updatedAt, isDeleted);
//        this.title = title;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    private String title;
//
