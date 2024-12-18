package com.scaler.finalnovprojectmodule.controller;

import com.scaler.finalnovprojectmodule.Dto.ErrorDto;
import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;
import com.scaler.finalnovprojectmodule.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    // CRUD APIs around product
    //@RequestMapping(value = "/products", ,method = RequestMethod.POST)
    // anyone doing POST request on the above API, the below method will be executed//
private ProductService productService;

public ProductController(ProductService productService) { // constructor to assign productservice to product controller. DI
    this.productService = productService;
}

    @PostMapping("/products")
    public void createProduct(Product product) {
        // help in creating a product
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

    // throwS - can throw

        
        System.out.println("Staring the API here");

    Product p = productService.getSingleProduct(id);

        System.out.println("Ending the API here");
        return p;
        // getting the product from the service


    }
    public void updateProduct(Product product) {


    }
    public void deleteProduct(Long id) {

    }
    @ExceptionHandler(ProductNotFoundException.class)
    // this will handle the exception if thrown by the method ProductNotFoundException.class


    public ErrorDto handleProductNotFoundException(Exception e){// it will take the whole stack trace
    ErrorDto errorDto = new ErrorDto();
    errorDto.setMessage(e.getMessage());

    return errorDto;
    }
}
