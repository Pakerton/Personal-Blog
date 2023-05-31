package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Account;
import com.example.demo.repositories.AccountRepository;

@Service
public class AccountServices {
	@Autowired
	AccountRepository accountRepository;
	
	public boolean isUsernameAvaliable(String username) {
		if(accountRepository.findByUsername(username) == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isAccountValid(String username, String password) {
		if(username.equals(accountRepository.findByUsername(username).getUsername())
				&& password.equals(accountRepository.findByUsername(username).getPassword())){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean createAccount(String username, String userEmail, String password, String rePassword) {
		if(password.equals(rePassword)) {
			accountRepository.save(new Account(username, password, userEmail));
			return true;
		}else {
			return false;
		}
	}
	

}
