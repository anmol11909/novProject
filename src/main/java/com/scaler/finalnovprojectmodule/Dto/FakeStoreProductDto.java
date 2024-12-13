package com.scaler.finalnovprojectmodule.Dto;

import com.scaler.finalnovprojectmodule.models.Category;
import com.scaler.finalnovprojectmodule.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto { // details I am getting from fakestore
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product getProduct(){ // mapping to our Product
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setTitle(category);
        product.setCategory(cat);
        return product;
    }

}
