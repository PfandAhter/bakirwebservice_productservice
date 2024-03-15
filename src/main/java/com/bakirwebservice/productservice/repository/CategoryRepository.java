package com.bakirwebservice.productservice.repository;

import com.bakirwebservice.productservice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryName (String categoryName);

}
