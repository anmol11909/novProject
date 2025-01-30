package com.scaler.finalnovprojectmodule.repository;

import com.scaler.finalnovprojectmodule.models.Category;
import com.scaler.finalnovprojectmodule.models.Product;

import com.scaler.finalnovprojectmodule.projections.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {
    // Select * from product where description is the decscription in arguement

    @Override
    Page<Product> findAll(Pageable pageable);
    // this will insert product in my product table
    Product save(Product product);


    Product findBytitle(String title);

    Product findByDescription(String description);

    Product findByid(long id);

    //HQL

    @Query("select p from Product p where p.category.catTitle=:catTitle")
    List<Product> getproductByCatTitle(@Param("catTitle") String catTitle);


    //NativeQuery
    @Query(value = "select * from Product p where p.category_id =:categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryIdNativeQueries(@Param("categoryId") long categoryId);

    @Query("select  p.title as title, p.id as id, p.description as description from Product p where p.category.id=:categoryId")
    List<ProductProjection> getProductsByCategoryIdUsingProjections(@Param("categoryId") long categoryId);


    Product deleteProductById(long id);

    Product findBydescription(String description);


}
