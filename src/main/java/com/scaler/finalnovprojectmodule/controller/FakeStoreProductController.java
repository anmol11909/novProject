//package com.scaler.finalnovprojectmodule.controller;
//
//import com.scaler.finalnovprojectmodule.Dto.fakeStoreProductDto;
//import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
//import com.scaler.finalnovprojectmodule.models.Product;
//import com.scaler.finalnovprojectmodule.service.FSProductService;
//import org.apache.coyote.BadRequestException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//public class  FakeStoreProductController {
//
//    private FSProductService fsProductService;
//
//    public FakeStoreProductController(FSProductService fsProductService) {
//        this.fsProductService = fsProductService;
//    }
//
//    @PostMapping("fsproduct")
//
//    public Product createProduct(@RequestBody fakeStoreProductDto fakeStoreProductDto) throws BadRequestException {
//        Product product = fsProductService.createProduct(fakeStoreProductDto.getId(), fakeStoreProductDto.getPrice(),
//                fakeStoreProductDto.getTitle(), fakeStoreProductDto.getDescription(), fakeStoreProductDto.getCategory(), fakeStoreProductDto.getImage());
//        return product;
//    }
//
//    // 3.) GET LIST OF PRODUCTS
//    @GetMapping("/fsproducts")
//    public List<Product> getAllProducts() {
//        List<Product> products = (List<Product>) fsProductService.getAllProducts();
//        return products;
//    }
//
//
//    // GET A SINGLE PRODUCT
//
//    @GetMapping("fsproduct{id}")
//    public Optional<Product> getSingleProduct(@PathVariable int id) throws ProductNotFoundException {
//        Optional<Product> product = fsproductService.getSingleProduct(id);
//        return product;
//    }
//
//    //PUT MAPPING
//    @PutMapping("fsproduct")
//    public Product updateProduct(@RequestBody FakeStoreProductDto fakeStoreProductDto) throws BadRequestException {
//        Product product = fsProductService.updateProduct(fakeStoreProductDto.getId(), fakeStoreProductDto.getPrice(), fakeStoreProductDto.getTitle(),
//                fakeStoreProductDto.getDescription(), fakeStoreProductDto.getCategory(), fakeStoreProductDto.getImage());
//        return product;
//    }
//
//
//// 5.) DELETING A PRODUCT
//
//    @DeleteMapping("fsproduct/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable int id) throws ProductNotFoundException {
//        return fsProductService.deleteProduct(id);
//
//    }
//
////    @ExceptionHandler(ProductNotFoundException.class)
////    // this will handle the exception if thrown by the method ProductNotFoundException.class
////
////    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e) { // it will take the whole stack trace
////
////    ErrorDto errorDto = new ErrorDto();
////    errorDto.setMessage(e.getMessage());
////    ResponseEntity<ErrorDto> response = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
////    return response;
////        //return null;
////    }
//
//}
