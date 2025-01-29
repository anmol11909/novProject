package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> getCategoryByName(String name);

    Optional<Category> createCategory(String CategoryName);
    List<Category> getAllCategories();
}
