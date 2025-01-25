//package com.scaler.finalnovprojectmodule.controller;
//
//import com.scaler.finalnovprojectmodule.Dto.ErrorDto;
//import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
//import com.scaler.finalnovprojectmodule.models.Product;
//import com.scaler.finalnovprojectmodule.service.ProductService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//
//public class ProductController {
//  private ProductService productService;
//  // connecting both(Dependency injection)
//  public ProductController(@Qualifier ("fakeStoreProductService") ProductService productService) {
//    // constructor to assign productservice to product controller. DI
//      this.productService = productService;
//  }
//// Spring IOC will create the object of the above controller(framework creates objects for you//
//
//    // APIS//
//
//// 1.) CREATE A PRODUCT//
//
//    @PostMapping("/products")
//    public Product createProduct(@RequestBody Product product) {
//    Product p = productService.createProduct(
//            product.getId(),
//            product.getTitle(),
//            product.getPrice(),
//            product.getImageUrl(),
//            product.getDescription(),
//            product.getCategory().getTitle());
//
//    return p;
//    }
//
////2.) GET A PRODUCT//
//
//@GetMapping("/products/{id}")
//public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
//
//    System.out.println("Starting API here");
//
//    Product p = productService.getSingleProduct(id);
//
//    System.out.println("Ending API here");
//
//    ResponseEntity<Product> response = new ResponseEntity<>(p, HttpStatus.OK);
//
//    return response;
//
//}
//
//// 3.) GET LIST OF PRODUCTS
//    @GetMapping("/products")
//    public List<Product> getAllProducts() {
//    return productService.getAllProducts();
//    }
//
//// 4.) UPDATING THE PRODUCT
//
//    @PutMapping("/products/{id}")
//    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
//    return productService.updateProduct(id, product);
//    }
//
//
//// 5.) DELETING A PRODUCT
//
//    @DeleteMapping("/products/{id}")
//
//    public void deleteProduct(@PathVariable("id") Long id) {
//     rewproductService.deleteProduct(id);
//        System.out.println("Product with id " + id + " has been deleted");
//    }
//
//    @ExceptionHandler(ProductNotFoundException.class)
//    // this will handle the exception if thrown by the method ProductNotFoundException.class
//
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e) { // it will take the whole stack trace
//
//    ErrorDto errorDto = new ErrorDto();
//    errorDto.setMessage(e.getMessage());
//    ResponseEntity<ErrorDto> response = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//    return response;
//        //return null;
//    }
//}
