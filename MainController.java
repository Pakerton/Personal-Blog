package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class MainController {
//	@GetMapping("/login") 
//	public String getLoginPage() {
//		return "login.html";
//	}
//
//	@GetMapping("/register") 
//	public String getRegisterPage() {
//		return "register.html";
//	}
//	
//	@GetMapping("/")
//	public String index() {
//		return "redirect:/hello";
//	}
//	
//	@GetMapping("/hello")
//	public ModelAndView getHelloPage(ModelAndView mav) {
//		UserDetails user = (UserDetails) SecurityContextHolder
//				.getContext().getAuthentication().getPrincipal();
//
//		mav.addObject("name", user.getUsername());
//		mav.setViewName("hello.html");
//		return mav;
//	}
//}

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.UserBlogService;
import com.example.demo.services.UserService;

	@Controller
	public class MainController {
		@Autowired
		UserService userService;
		@Autowired
		UserBlogService userBlogService;
		
		@GetMapping("/login")
		public String ctrl() {
			return ("login.html");
		}
		
		@GetMapping("/services")
		public String ctrl2() {
			return ("services.html");
		}
		
		@GetMapping("/register")
		public String ctrl3() {
			return ("register.html");
		}


	    @PostMapping("/user-login")
	    public ModelAndView login(@RequestParam String username, @RequestParam String password, ModelAndView mav) {
	    	
	    	
	    	if(userService.isUsernameAvaliable(username)==false &&  userService.isAccountValid(username, password)) {
	    		mav.addObject("wrongInput", false);
	    		mav.addObject("name", username);
	    		mav.setViewName("services.html");
	    		return mav;
	    	}else {
	    		mav.addObject("wrongInput", true);
	    		mav.setViewName("login.html");
	    		return mav;
	    	}
	    }
	    
	    @PostMapping("/user-register")
	    public ModelAndView register(@RequestParam String username, @RequestParam String email,@RequestParam String password, @RequestParam String rePassword, ModelAndView mav) {
	    if(userService.isEmailAvaliable(email)) {
	    	mav.addObject("emailIsTaken", false);
	    	if(userService.isUsernameAvaliable(username)) {
	    		mav.addObject("usernameIsTaken", false);
	    	    if(userService.createAccount(username, email, password, rePassword) == true) {
			    	mav.addObject("name", username);
			    	mav.addObject("rePasswordNotMatched", false);
			    	mav.setViewName("registered.html");
			    	return mav;
	    	    }else {
	    	    	mav.addObject("rePasswordNotMatched", true);
			    	mav.setViewName("register.html");
			    	return mav;
	    	    }
	    	}else {
	    		mav.addObject("usernameIsTaken", true);
	    		
	    		mav.setViewName("register.html");
	    		return mav;
	    	}
	    }else {
	    	    
	    		mav.addObject("emailIsTaken", true);
	    		
	    		mav.setViewName("register.html");
	    		return mav;
	    	}
	    }
//		@GetMapping("/login")
//		public String getLoginPage() {
//			return "login.html";
//		}
//			
//		@GetMapping("/register") 
//		public String getRegisterPage() {
//			return "register.html";
//		}
//		@GetMapping("/")
//		public String getIndex() {
//			return "redirect:/hello";
//		}
//		
//		@GetMapping("/BlogHP")
//		public String getHelloPage(Model model) {
//			UserDetails user = (UserDetails) SecurityContextHolder
//					.getContext().getAuthentication().getPrincipal();
//	
//			model.addAttribute("name",user.getUsername());
//			return "BlogHP.html";
//		}
//		
//		@PostMapping("/login")
//		public ModelAndView login(@RequestParam String username, @RequestParam String password, ModelAndView mav) {
//			if(UserService.validUser(username, password)) {
//				
//			}
//		}
		
		@PostMapping("/WriteBlog")
		public void saveBlog(@RequestParam String title, @RequestParam String text) {
			
		}

}
