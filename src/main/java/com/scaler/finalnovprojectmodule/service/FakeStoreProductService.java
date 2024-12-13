package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{

    // Inside this fakestore is going to be third party//


    public Product getSingleProduct(long id) {
        System.out.println("We are in single product method");
        return null;
    }

    public List<Product> getAllProducts() {
        return List.of();
    }

    public Product createProduct(Product product) {
        return null;
    }
}
