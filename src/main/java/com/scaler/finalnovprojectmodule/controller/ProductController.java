package com.scaler.finalnovprojectmodule.controller;

import com.scaler.finalnovprojectmodule.Dto.ErrorDto;
import com.scaler.finalnovprojectmodule.Dto.ProductRequestDto;
import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;
import com.scaler.finalnovprojectmodule.service.DBProductService;
import com.scaler.finalnovprojectmodule.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.apache.coyote.BadRequestException;
//import org.hibernate.query.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final DBProductService dbProductService;

    //CREATE PRODUCT
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(
            @Valid @RequestBody ProductRequestDto requestDto) throws BadRequestException {

        Product p = productService.createProduct(
                requestDto.getPrice(), requestDto.getTitle(), requestDto.getDescription(),
                requestDto.getCategory().getCatTitle(), requestDto.getImageUrl());
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
    //GET All PRODUCTS
//    @GetMapping("products")
//    public ResponseEntity<List<Product>> getAllProducts() {
//        productService.getAllProducts();
//        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
//    }

    //GET SINGLE PRODUCT

    @GetMapping("product/{id}")

    public ResponseEntity<Product> getProduct(@PathVariable("id") long product_id) throws ProductNotFoundException{
        Product p = productService.getSingleProduct(product_id);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        throw new ProductNotFoundException("Product with id " + product_id + " not found in the database");

    }


    //UPDATE PRODUCT
    @PutMapping("product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product p = productService.updateProduct(product.getId(), product.getPrice(), product.getTitle(),
                product.getDescription(), product.getCategory().getCatTitle(), product.getImage_url());
        return new ResponseEntity<>(p, HttpStatus.OK);

    }

    //
    //DELETE PRODUCT
    @DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long product_id) {

        return productService.deleteProduct(product_id);

        //return new ResponseEntity<>("Product deleted", HttpStatus.ACCEPTED);
    }

    //GET ALL PRODUCTS USING PAGINATION

    @GetMapping("products")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam("pageNumber") int pageNumber,
                                                         @RequestParam("pageSize")int pageSize, @RequestParam("fieldName") String fieldName){
        Page<Product> products = productService.getAllProducts(pageNumber, pageSize, fieldName);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    //PRODUCT NOT FOUND EXCEPTION

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto productNotFoundExceptionHandler(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }

    //BAD REQUEST EXCEPTION

    @ExceptionHandler(BadRequestException.class)
    public ErrorDto badRequestExceptionHandler(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }
}
