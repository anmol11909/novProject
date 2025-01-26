package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.Dto.fakeStoreProductDto;
import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")

public class FSProductService implements ProductService {
    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<Product> getSingleProduct(Long id) throws ProductNotFoundException {
        System.out.println("We are in Single Product");

        fakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found with id " + id);
        }
        System.out.println(fakeStoreProductDto.toString());

        return fakeStoreProductDto.getProduct();
    }

    @Override
    public List<Product> getAllProducts() {

        System.out.println("Fetching all products");

        fakeStoreProductDto[] fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products", fakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (fakeStoreProductDto productDto : fakeStoreProductDto) {
            products.add(productDto.getProduct());
        }
        return products;
    }

    //CREATE PRODUCT
    @Override
    public Product createProduct(Long id, String title, Double price, String description, String category, String imageUrl) {
        fakeStoreProductDto fakeStoreProductDto = new fakeStoreProductDto();

        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(imageUrl);

        fakeStoreProductDto response = restTemplate.postForObject("http://fakestoreapi.com/products",
                fakeStoreProductDto, fakeStoreProductDto.class);
        return response.getProduct();
    }





//UPDATE PRODUCT
@Override
public Product updateProduct(Long id, Product updateProduct) {
//    System.out.println("update product with id:" + id);
//
//    fakeStoreProductDto fakeStoreProductDto = new fakeStoreProductDto();
//    fakeStoreProductDto.setId(id);
//    fakeStoreProductDto.setTitle(updateProduct.getTitle());
//    fakeStoreProductDto.setDescription(updateProduct.getDescription());
//    fakeStoreProductDto.setPrice(updateProduct.getPrice());
//    //fakeStoreProductDto.setCategory(updateProduct.getCategory().getName());
//    fakeStoreProductDto.setImage(updateProduct.getImageUrl());
//    restTemplate.put("http://fakestoreapi.com/products/" + id, fakeStoreProductDto, fakeStoreProductDto.class);
//    return fakeStoreProductDto.getProduct();

    return null;
}

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("Product with ID " + id + " has been deleted");
    }
}


