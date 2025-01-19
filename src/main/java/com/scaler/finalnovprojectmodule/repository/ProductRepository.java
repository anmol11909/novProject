package com.scaler.finalnovprojectmodule.repository;

import com.scaler.finalnovprojectmodule.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
    // Select * from product where description is the decscription in arguement


    Product findByDescription(String description);

    Product findByTitle(String title);

    // this will insert product in my product table
    Product save(Product product);

    Product deleteProductById(Long id);

}
