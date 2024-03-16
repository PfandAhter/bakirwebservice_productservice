package com.bakirwebservice.productservice.repository;

import com.bakirwebservice.productservice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select c from Category c where ((?1 is null  and c.parentId is null) or c.categoryId = ?1) and c.status = '1' ")
    List<Category> findCategoriesByCriteria(Long categoryId);

    Category findCategoryByCategoryId(Long categoryId);

}
