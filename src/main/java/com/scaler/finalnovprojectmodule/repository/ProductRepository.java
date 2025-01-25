package com.scaler.finalnovprojectmodule.repository;

import com.scaler.finalnovprojectmodule.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {
    // Select * from product where description is the decscription in arguement


    Product findByDescription(String description);

    Product findByTitle(String title);

    // this will insert product in my product table
    Product save(Product product);


    Product deleteProductById(Long id);

    Product findBydescription(String description);


    //HQL
//
//    @Query("select p from Product p where p.category.id =:categoryId")
//    List<Product> getProductsByCategoryId(@Param("categoryId") Long categoryId);
//
//    //NativeQuery
//
//    @Query(value = "select * from product p where p.category_id =:categoryId", nativeQuery = true)
//    List<Product> getProductsByCategoryIdNativeQueries(@Param("categoryId") Long categoryId);
//
//
//    @Query("select  p.title as title, p.id as id from Product p where p.category.id=:categoryId")
//    List<ProductProjection> getProductsByCategoryIdUsingProjections(@Param("categoryId") Long categoryId);

}
