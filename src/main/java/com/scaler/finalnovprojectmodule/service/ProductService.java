package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface ProductService {
    Optional<Product> getSingleProduct(long id) throws ProductNotFoundException;
//
    List<Product> getAllProducts();

    //Product createProduct(Long id, String title, Double price, String description, String Category, String image);

    Product createProduct(long id, String title, String description, String category, String imageUrl) throws BadRequestException;


   // Product updateProduct(Long id, Product product);

    void deleteProduct(long id);

//    Product createProduct(double price, Sting title, String description, String category, String imageUrl) throws BadRequestException;
}
