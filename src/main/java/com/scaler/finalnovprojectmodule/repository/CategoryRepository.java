package com.scaler.finalnovprojectmodule.repository;

import com.scaler.finalnovprojectmodule.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Category findByTitle(String title);

    Optional<Category> findByCatTitle(String catTitle);

}
