package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.models.Account;
import com.example.demo.models.UserBlog;
import com.example.demo.repositories.UserBlogRepository;

@Service
public class BlogService {
    @Autowired
    UserBlogRepository repository;
    
    
    public boolean saveBlog(String title, String text) {
    	
    			repository.save(new UserBlog(title, text));
    			return true;
    		
    	
    }
    
    public List<UserBlog> findAllBlog(){
    	
    	return repository.findAll();
    }
    
 public UserBlog findByTitle(String title){
    	
    	return repository.findByTitle(title);
    }

	public boolean DelBlog(String title) {
	 if(repository.findByTitle(title)!=null) {
		repository.deleteById(repository.findByTitle(title).getBlogId());
		return true;
	 }else {
		 return false;
	 }
	}
	
	public String editBlog(String title) {
		return repository.findByTitle(title).getText();	
		}

	public UserBlog searchBlog(String title) {
		return repository.findByTitle(title);
		
	}

	public boolean update(Long id, String title, String text) {
		repository.findByBlogId(id).setTitle(title);
		repository.findByBlogId(id).setText(text);;
		return true;
	}
}
