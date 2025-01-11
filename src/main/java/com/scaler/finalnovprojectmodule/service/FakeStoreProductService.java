package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.Dto.fakeStoreProductDto;
import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")

public class fakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
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

        System.out.println("Fetching all prducts");

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
    public Product createProduct(Long id, String title, Double price, String description, String Category, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProduct.class
        );

        return null;
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }



//UPDATE PRODUCT

    @Override
    public Product updateProduct(long id, String title, Double price, String description, String Category, String imageUrl) {
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setId(id);
//        fakeStoreProductDto.setTitle(title);
//        fakeStoreProductDto.setPrice(price);
//        fakeStoreProductDto.setDescription(description);
//       // fakeStoreProductDto.setCategory(category);
//        fakeStoreProductDto.setImage(imageUrl);

        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("Product with ID " + id + " has been deleted");
    }
}