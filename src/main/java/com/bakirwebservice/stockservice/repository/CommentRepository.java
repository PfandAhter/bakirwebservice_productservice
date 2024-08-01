package com.bakirwebservice.stockservice.repository;

import com.bakirwebservice.stockservice.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,String> {

    @Query("Select c from Comment c where c.productId = ?1 and c.active = 1 ")
    List<Comment> findCommentsByProductId (String productId);

    @Query("select count (*)  from Comment c group by c.productId having c.productId = ?1 ")
    Integer findCommentCount (String productId);
}
