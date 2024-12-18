package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ProductService {
    Product getSingleProduct(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();
    Product createProduct(Product product);
}
