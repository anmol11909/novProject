package com.scaler.finalnovprojectmodule.controller;

import com.scaler.finalnovprojectmodule.models.Category;
import com.scaler.finalnovprojectmodule.service.DBCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    DBCategoryService dbCategoryService;

    public CategoryController(DBCategoryService dbCategoryService) {
        this.dbCategoryService = dbCategoryService;
    }


    // new entry in Category Table

    @PostMapping("category")
    public ResponseEntity<Optional<Category>> addCategory(@RequestBody Category category){
        Optional<Category> cat = dbCategoryService.createCategory(category.getCatTitle());
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

    @GetMapping("category")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(dbCategoryService.getAllCategories(),HttpStatus.OK);
    }
//
    @GetMapping("category/{name}")
    public ResponseEntity<Optional<Category>> getCategoryByName(@PathVariable("name") String name){
        return new ResponseEntity<>(dbCategoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
