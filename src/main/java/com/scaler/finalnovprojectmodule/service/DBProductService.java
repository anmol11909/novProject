package com.scaler.finalnovprojectmodule.service;
import com.scaler.finalnovprojectmodule.models.Category;
import com.scaler.finalnovprojectmodule.models.Product;

import com.scaler.finalnovprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.finalnovprojectmodule.repository.CategoryRepository;
import com.scaler.finalnovprojectmodule.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    public class DBProductService implements ProductService {


    //@Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    private RedisTemplate redisTemplate;

    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository, RedisTemplate redisTemplate) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {

        Product redisProduct = (Product) redisTemplate.opsForHash().get("PRODUCTS", "product" + id);
        if (redisProduct != null) {
            return redisProduct;
        }
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }

        Product product = productOptional.get();


        redisTemplate.opsForHash().put("PRODUCTS", "product" + id, product);
        return product;

    }

//        Optional<Product> product = productRepository.findById(id);
//        if(product==null){
//            throw new ProductNotFoundException("Product not found");
//        }
//        return product;


    //PAGINATION TO GET ALL PRODUCTS

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName) {
        Page<Product> products = productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(fieldName).ascending()));
        return products;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

//    @Override
//    public List<Product> getAllProducts() {
//        List<Product> products = new ArrayList<>();
//        productRepository.findAll().forEach(products::add);
//        return products;
//    }

    @Override
    public Product createProduct(double price, String title, String description, String category, String imageUrl) throws BadRequestException {
        Product p = new Product();
        p.setPrice(price);
        p.setTitle(title);
        p.setDescription(description);
        Optional<Category> currCat = categoryRepository.findByCatTitle(category);

        if (currCat.isPresent()) {
            p.setCategory(currCat.get());
        } else {
            Category newCat = new Category();
            newCat.setCatTitle(category);
            categoryRepository.save(newCat);
            p.setCategory(newCat);
        }
        p.setImage_url(imageUrl);
        Product savedProduct = productRepository.save(p);
        return savedProduct;
    }

    @Override
    public Product updateproduct(long id, double price, String title, String description, String category, String imageUrl) {
        return null;
    }


    @Override


    //@Transactional
    public ResponseEntity<String> deleteProduct(long id) {
//       // Optional<Product> product = productRepository.findById(id);
//        if (product.isPresent()) {
//            productRepository.deleteById(id);
//            return ResponseEntity.ok("Product deleted succesfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
//        }

        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

//    @Override
//    public Product createProduct(long id, double price, String title, String description, String category, String imageUrl) throws BadRequestException {
//        return null;
//    }

    @Override
    public Product updateProduct(long id, double price, String title, String description, String category, String imageUrl) {
        Product p = new Product();
        p.setId(id);
        p.setPrice(price);
        p.setTitle(title);
        p.setDescription(description);
        p.setImage_url(imageUrl);

        Optional<Category> currCat = categoryRepository.findByCatTitle(category);
        if (currCat.isPresent()) {
            p.setCategory(currCat.get());
        } else {
            Category newCat = new Category();
            newCat.setCatTitle(category);
            categoryRepository.save(newCat);
            p.setCategory(newCat);
        }
        productRepository.save(p);
        return p;
    }
}



//        ProductRepository productRepository;
//        CategoryRepository categoryRepository;
//        public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
//            this.productRepository = productRepository;
//            this.categoryRepository = categoryRepository;
//        }
//
//        @Override
//        public Optional<Product> getSingleProduct(long id) throws ProductNotFoundException{
//            Optional<Product> product = productRepository.findById(id);
//            if(product==null){
//                throw new ProductNotFoundException("Product not found");
//            }
//            return product;
//        }
//
//        @Override
//    public List<Product> getAllProducts()


