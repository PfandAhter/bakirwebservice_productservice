package com.bakirwebservice.stockservice.repository;

import com.bakirwebservice.stockservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p from Product p where (p.categoryId = ?1) and p.active = 1")
    List<Product> findProductsByCategoryId(String categoryId);

    Product findProductsByProductId(String productId);

}
