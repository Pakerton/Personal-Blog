package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
	UserRepository repository;
    
    public boolean isUsernameAvaliable(String username) {
		if(repository.findByUsername(username) == null) {
			return true;
		}else {
			return false;
		}
	}
    
    public boolean isEmailAvaliable(String email) {
		if(repository.findByEmail(email).getUser_email() == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isAccountValid(String username, String password) {
		if(username.equals(repository.findByUsername(username).getUser_name())
				&& password.equals(repository.findByUsername(username).getUser_password())){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean createAccount(String username, String email, String password, String rePassword) {
		if(password.equals(rePassword)) {
			repository.save(new User(username, email, password));
			return true;
		}else {
			return false;
		}
	}
    
//    public boolean validUser(String username, String password) {
//    	
//    	if(repository.findByUsername(username)==null) {
//    		return false;
//    	}else {
//    	    if(password.equals(repository.findByUsername(username).getUser_password())){
//    	    	return true;
//    	}else {
//    		return false;
//    	}
//    	}
//    }
    
}
