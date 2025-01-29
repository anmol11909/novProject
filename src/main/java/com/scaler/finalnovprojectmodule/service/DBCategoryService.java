package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.models.Category;
import com.scaler.finalnovprojectmodule.repository.CategoryRepository;
import com.scaler.finalnovprojectmodule.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DBCategoryService implements CategoryService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    public DBCategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Category> getCategoryByName(String name) {
        System.out.println("This is the Category you are searching for");

        Optional<Category> category = categoryRepository.findByCatTitle(name);
        return category;
//
//
//        categoryRepository.save(newCategory);
//        return Optional.of(newCategory);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categories.add(category));

        return categories;
    }

    @Override
    public Optional<Category> createCategory(String categoryName) {
        Category newCategory = new Category();
        newCategory.setCatTitle(categoryName);
        categoryRepository.save(newCategory);
        return Optional.of(newCategory);
    }

//    public Optional<Category> createCategory(String catTitle) {
//        return null;
//    }

}
////
////    @Override
////    public Optional<Category> getCategoryByName(String name) {
////        return Optional.empty();
////    }
////
////
//
//
//}
