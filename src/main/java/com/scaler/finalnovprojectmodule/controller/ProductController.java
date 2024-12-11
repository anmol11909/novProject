package com.scaler.finalnovprojectmodule.controller;

import com.scaler.finalnovprojectmodule.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    // CRUD APIs around product
    //@RequestMapping(value = "/products", ,method = RequestMethod.POST)
    // anyone doing POST request on the above API, the below method will be executed//

    @PostMapping("/products")
    public void createProduct(Product product) {
        // help in creating a product
    }
    public Product getProductById(Long id) {
        return null;
        // getting the product

    }
    public void updateProduct(Product product) {


    }
    public void deleteProduct(Long id) {

    }
}
