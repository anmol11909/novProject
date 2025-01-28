package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface ProductService {

    //PAGINATION FOR GET ALL PRODUCTS

    Product getSingleProduct(long id) throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldname);

//
    List<Product> getAllProducts();

    //Product createProduct(Long id, String title, Double price, String description, String Category, String image);

    Product createProduct(double price, String title, String description, String category, String imageUrl) throws BadRequestException;

    Product updateproduct(long id, double price, String title, String description, String category, String imageUrl);

 ResponseEntity<String> deleteProduct(long id);

Product updateProduct(long id, double price, String title, String description, String category, String imageUrl);
}
