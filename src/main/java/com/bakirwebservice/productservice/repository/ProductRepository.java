package com.bakirwebservice.productservice.repository;

import com.bakirwebservice.productservice.model.entity.Category;
import com.bakirwebservice.productservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByProductCode (Long productCode);

    List<Product> findProductsByCategory (Category category);

    Product findByProductCode (Long productCode);
}
