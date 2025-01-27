package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.Dto.fakeStoreProductDto;
import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stripe.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;

@Slf4j
@Service

public class FSProductService implements ProductService {

    private final RestTemplate fsrestTemplate;

    public FSProductService(RestTemplate fsrestTemplate)
    {
        this.fsrestTemplate = fsrestTemplate;
    }

    @Override
    public Optional<Product> getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("Inside FSProductService service");

        fakeStoreProductDto fakeStoreProductDto =
                fsrestTemplate.getForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found with id " + id);
        }
        System.out.println(fakeStoreProductDto.toString());

        Optional<Product> product = Optional.of(fakeStoreProductDto.getProduct());
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName){
        return null;
    }

    @Override
    public ResponseEntity<String> deleteProduct(long id){
        System.out.println("Inside FSProductService service DELETE method");
        fsrestTemplate.delete("https://fakestoreapi.com/products/" + id);
        return ResponseEntity.ok().build();
    }


    @Override
    public List<Product> getAllProducts(){
        fakeStoreProductDto[] fakeStoreProductDtos = fsrestTemplate.getForObject(
                "https://fakestoreapi.com/products", fakeStoreProductDto[].class
        );

        List<Product> products = new ArrayList<>();
        for(fakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(fakeStoreProductDto.getProduct());
        }
        return products;
    }




    @Override
    public Product createProduct(double price, String title, String description, String category, String imageUrl) throws BadRequestException {
        return null;
    }


    //CREATE PRODUCT
    @Override
    public Product createProduct(long id, String title, Double price, String description, String category, String imageUrl) {
        fakeStoreProductDto fakeStoreProductDto = new fakeStoreProductDto();

        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(imageUrl);

        fakeStoreProductDto response = fsrestTemplate.postForObject("http://fakestoreapi.com/products",
                fakeStoreProductDto, fakeStoreProductDto.class);
        return response.getProduct();
    }



    @Override
    public Product updateProduct(long id, double price, String title, String description, String category, String imageUrl){
        fakeStoreProductDto fakeStoreProductDto = new fakeStoreProductDto();

//fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(imageUrl);

        fsrestTemplate.put("http://fakestoreapi.com/products/" + id, fakeStoreProductDto);

        return fakeStoreProductDto.getProduct();

    }

}


