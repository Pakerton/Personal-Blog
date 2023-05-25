package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserBlogRepository;

@Service
public class UserBlogService {
    @Autowired
    UserBlogRepository repository;
    
    
    public void saveBlog(String title, String text) {
    	repository.save(New Userblog(admin_id, title, text, publish_date, publish_time));
    }
}
