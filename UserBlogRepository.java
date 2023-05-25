package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserBlog;

@Repository
public interface UserBlogRepository extends JpaRepository<UserBlog,Long>{
    
}
