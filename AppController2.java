package com.example.demo.controller;

import java.util.List;

//import java.util.HashMap;
//import java.util.Map;

//import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.UserBlog;
//import com.example.demo.models.Account;
//import com.example.demo.repositories.AccountRepository;
import com.example.demo.services.AccountServices;
import com.example.demo.services.BlogService;


@Controller
public class AppController2 {
	@Autowired
	AccountServices accountServices;
	@Autowired
	BlogService blogServices;
	
	String blogText="";
//Map<String, User> users = new HashMap<>();
//	
//	public AppController2(){
//		users.put("Tom",new User("Tom", "Tom"));
//		users.put("Jerry", new User("Jerry", "Jerry"));
//		users.put("Bob", new User("Bob", "Bob"));
//		users.put("admin", new User("admin", "admin"));
//	}
	
	@GetMapping("/login")
	public String ctrl() {
		return "login.html";
	}
	
	@GetMapping("/services")
	public String ctrl2() {
		return "services.html";
	}
	
	@GetMapping("/register")
	public String ctrl3() {
		return "register.html";
	}
    
	@GetMapping("/writeblog")
	public String ctrl4() {
		return "CreateBlog.html";
	}
	
	@GetMapping("/showAllBlogs")
	public ModelAndView ctrl5(ModelAndView mav) {
		if(blogServices.findAllBlog()==null) {
    		
    		mav.addObject("blogText", "No Text");
    		
    		mav.setViewName("BlogHP.html");
    		return mav;
    		}else {
    			mav.addObject("blogText", "No Text");
    			List<UserBlog> text = blogServices.findAllBlog();
    			for(UserBlog t: text) {
    				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
    			}
    			
        		mav.addObject("blogText", blogText);
        		

        		mav.setViewName("BlogHP.html");
        		blogText = "";
        		return mav;
    		}
	}

    @PostMapping("/user-login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, ModelAndView mav) {
    	
    	
    	if(accountServices.isUsernameAvaliable(username)==false &&  accountServices.isAccountValid(username, password)) {
//    		mav.addObject("wrongInput", false);
//    		mav.addObject("name", username);
    		if(blogServices.findAllBlog()==null) {
    		
    		mav.addObject("blogText", "No Text");
    		
    		mav.setViewName("BlogHP.html");
    		return mav;
    		}else {
    			mav.addObject("blogText", "No Text");
    			List<UserBlog> text = blogServices.findAllBlog();
    			for(UserBlog t: text) {
    				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
    			}
    			
        		mav.addObject("blogText", blogText);
        		

        		mav.setViewName("BlogHP.html");
        		blogText = "";
        		return mav;
    		}
    	}else {
    		mav.addObject("wrongInput", true);
    		mav.setViewName("login.html");
    		return mav;
    	}
    }
    
    @PostMapping("/user-register")
    public ModelAndView register(@RequestParam String username,@RequestParam String userEmail, @RequestParam String password, @RequestParam String rePassword, ModelAndView mav) {
    	if(accountServices.isUsernameAvaliable(username)) {
    	    if(accountServices.createAccount(username, userEmail, password, rePassword) == true) {
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
    		mav.addObject("rePasswordNotMatched", false);
    		mav.setViewName("register.html");
    		return mav;
    	}
    }
    
    @PostMapping("/addNewBlog")
    public ModelAndView newBlog(@RequestParam String title, @RequestParam String text, ModelAndView mav) {
    	if(blogServices.saveBlog(title, text)) {
//    		mav.addObject("blog_title", title);
//    		mav.addObject("blog_text", text);
//    		mav.setViewName("BlogHP.html");
//    		return mav;
    		if(blogServices.findAllBlog()==null) {
//    		mav.addObject("blogTitle", "No Title");
    			mav.addObject("blogText", "No Text");
//    		List<UserBlog> text2 = blogServices.findAllBlog();
//			for(UserBlog t: text2) {
//				blogText = blogText + "\n" + "\n" + t.getTitle() + "\n" + t.getText();
//			}
//			
//    		mav.addObject("blogText", blogText);
//    		

    		mav.setViewName("BlogHP.html");
    		blogText = "";
    		return mav;
    		}else {
    			mav.addObject("blogText", "No Text");
    			List<UserBlog> text2 = blogServices.findAllBlog();
    			for(UserBlog t: text2) {
    				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
    			}
    			
        		mav.addObject("blogText", blogText);
        		

        		mav.setViewName("BlogHP.html");
        		blogText = "";
        		return mav;
    		}
    	}else {
    		mav.addObject("title", title);
    		mav.addObject("text", text);
    		
    		mav.setViewName("CreateBlog.html");
    		return mav;
    	}
    }
    
    @PostMapping("/updateBlog")
    public ModelAndView updateBlog(@RequestParam String title, @RequestParam String text, @RequestParam Long id, ModelAndView mav) {
    	if(blogServices.update(id, title, text)) {

    		if(blogServices.findAllBlog()==null) {

    			mav.addObject("blogText", "No Text");


    		mav.setViewName("BlogHP.html");
    		blogText = "";
    		return mav;
    		}else {
    			mav.addObject("blogText", "No Text");
    			List<UserBlog> text2 = blogServices.findAllBlog();
    			for(UserBlog t: text2) {
    				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
    			}
    			
        		mav.addObject("blogText", blogText);
        		

        		mav.setViewName("BlogHP.html");
        		blogText = "";
        		return mav;
    		}
    	}else {
    		mav.addObject("title", title);
    		mav.addObject("text", text);
    		
    		mav.setViewName("CreateBlog.html");
    		return mav;
    	}
    }
   
    @PostMapping("/delBlog")
    public ModelAndView delBlog(@RequestParam String title, ModelAndView mav) {
    	if(blogServices.DelBlog(title)==true) {
    		if(blogServices.findAllBlog()==null) {
        		mav.addObject("blogText", "No Text");
        		
        		mav.setViewName("BlogHP.html");
        		return mav;
        		}else {
        			List<UserBlog> text2 = blogServices.findAllBlog();
        			for(UserBlog t: text2) {
        				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
        			}
        			
            		mav.addObject("blogText", blogText);
            		

            		mav.setViewName("BlogHP.html");
            		blogText = "";
            		return mav;
        		}
    	}else {
    		if(blogServices.findAllBlog()==null) {
//        		mav.addObject("blogTitle", "No Title");
        		mav.addObject("blogText", "No Text");
//        		mav.addObject("newTr", "<tr>\r\n"
//        				+ "        <!-- <td></td> -->\r\n"
//        				+ "        <article><td colspan=\"5\"  rows=\"40\" cols=\"90\" name=\"text\" style=\"overflow-y: scroll; overflow-x: auto;\"><p>[[${blogTitle}]]</p> <br><br> <p>[[${blogText}]]</p><br><br><br><br></td>></article>\r\n"
//        				+ "        \r\n"
//        				+ "    </tr>\r\n"
//        				+ "   \r\n"
//        				+ "    [[${newTr}]]");
//        		mav.addObject("[[${blogTitle}]]");
//        		mav.addObject("[[${blogText}]]");
        		mav.setViewName("BlogHP.html");
        		return mav;
        		}else {
        			List<UserBlog> text = blogServices.findAllBlog();
        			for(UserBlog t: text) {
        				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
        			}
        			
            		mav.addObject("blogText", blogText);
            		

            		mav.setViewName("BlogHP.html");
            		blogText = "";
            		return mav;
            		
        		}
    	}
    }
    
    @PostMapping("/searchBlog")
    public ModelAndView searchBlog(@RequestParam String title, ModelAndView mav) {
    	if(blogServices.searchBlog(title)!=null) {
    		blogText = blogText + "\n" + "\n" + blogServices.searchBlog(title).getTitle() + "\n" + blogServices.searchBlog(title).getText();
    		mav.addObject("blogText", blogText);
    		

    		mav.setViewName("BlogHP.html");
    		blogText = "";
    		return mav;
    	}else {
    		if(blogServices.findAllBlog()==null) {     		
        		mav.addObject("blogText", "No Text");

        		mav.setViewName("BlogHP.html");
        		return mav;
        		}else {
        			List<UserBlog> text = blogServices.findAllBlog();
        			for(UserBlog t: text) {
        				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
        			}
        			
            		mav.addObject("blogText", blogText);
            		

            		mav.setViewName("BlogHP.html");
            		blogText = "";
            		return mav;
    	}}
    }
    
    @PostMapping("/editBlog")
    public ModelAndView editBlog(@RequestParam String title, ModelAndView mav) {
    	if(blogServices.editBlog(title)!=null) {
    		mav.addObject("title", title);
    		mav.addObject("text", blogServices.editBlog(title));
    		mav.addObject("id", blogServices.findByTitle(title).getBlogId());
    		mav.setViewName("updateBlog.html");
//    		blogServices.DelBlog(title);
    		return mav;
    	}else {
    		if(blogServices.searchBlog(title)!=null) {
        		blogText = blogText + "\n" + "\n" + blogServices.searchBlog(title).getTitle() + "\n" + blogServices.searchBlog(title).getText();
        		mav.addObject("blogText", blogText);
        		

        		mav.setViewName("BlogHP.html");
        		blogText = "";
        		return mav;
        	}else {
        		if(blogServices.findAllBlog()==null) {     		
            		mav.addObject("blogText", "No Text");

            		mav.setViewName("BlogHP.html");
            		return mav;
            		}else {
            			List<UserBlog> text = blogServices.findAllBlog();
            			for(UserBlog t: text) {
            				blogText = blogText + "\n" + "\n" +"TITLE: "+ t.getTitle() + "\n" +"TEXT:"+ t.getText();
            			}
            			
                		mav.addObject("blogText", blogText);
                		

                		mav.setViewName("BlogHP.html");
                		blogText = "";
                		return mav;
            		}}}
    }
}
