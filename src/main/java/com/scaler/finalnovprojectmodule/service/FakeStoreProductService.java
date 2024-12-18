package com.scaler.finalnovprojectmodule.service;

import com.scaler.finalnovprojectmodule.Dto.FakeStoreProductDto;
import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{

    // Inside this fakestore is going to be third party//
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Product getSingleProduct(long id) throws ProductNotFoundException {

        System.out.println("Inside fakestore product service");
        FakeStoreProductDto fakeStoreProductDto =
        restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        // above This method sends an HTTP GET request to the specified URL with product id
        // and maps the response body into a Java object of the specified type (fakestoreproductdto.class in this case).
        // get request from the API(URL) for the object of the specified class
        // jackson will map the response that we will get from the API to fakeStoreProductDto class's object

       // System.out.println(fakeStoreProductDto.toString());

        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException("Product not found with id " + id);
        }
        return fakeStoreProductDto.getProduct();
        //COMPLETE API
    }

    public List<Product> getAllProducts() {
        return List.of();
    }

    public Product createProduct(Product product) {
        return null;
    }
}
