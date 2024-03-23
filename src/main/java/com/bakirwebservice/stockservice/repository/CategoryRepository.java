package com.bakirwebservice.stockservice.repository;

import com.bakirwebservice.stockservice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

    @Query("select c from Category c where ((?1 = 'all' and c.parentId is null) or c.categoryId = ?1) and c.status = '1' ")
    List<Category> findCategoriesByCriteria(String categoryId);

    Category findCategoryByCategoryId(String categoryId);

}
