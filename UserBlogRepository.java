package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserBlog;

@Repository
public interface UserBlogRepository extends JpaRepository<UserBlog,Long>{
    UserBlog findByTitle(String title);
    List<UserBlog> findAll();
    UserBlog findByBlogId(Long blogId);

}
