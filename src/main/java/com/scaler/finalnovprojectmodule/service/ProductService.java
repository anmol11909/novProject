package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
//
    List<Product> getAllProducts();

    Product createProduct(Long id, String title, Double price, String description, String Category, String image);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

}
