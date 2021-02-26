package com.codingdojo.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.services.UserService;

@Controller
public class UserController {
	 private final UserService userService;
	    
	    public UserController(
	    		UserService userService
	    		) {
	        this.userService = userService;
	    }
	    
		@RequestMapping("")
		private String redirectIndex() {
			return "redirect:/login";
		}
	    
	    @RequestMapping("/registration")
	    public String registerForm(
	    		@ModelAttribute("user") User user,
	    		Model model
	    		) {
	        return "registration-page.jsp";
	    }
	    @RequestMapping("/login")
	    public String login(
	    		HttpSession session
	    		) {
	    	session.invalidate();
	        return "login-page.jsp";
	    }
	    
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(
	    		@Valid @ModelAttribute("user") User user, 
	    		BindingResult result, 
	    		HttpSession session,
	    		Model model
	    		) {
	    	
	    	if (result.hasErrors()) {
	    		return "registration-page.jsp";
			} 
	    	boolean passwordLength = userService.checkPasswordLength(user.getPassword());
	    	if(passwordLength) {
	    		model.addAttribute("passwordError", "<div class='col-12'><small>Passwords must be at least 8 characters </small></div>");
	            return "registration-page.jsp";
	    	}
	    	passwordLength = userService.checkPasswordLength(user.getPasswordConfirmation());
	    	if(passwordLength) {
	    		model.addAttribute("passwordConfirmationError", "<div class='col-12'><small>Passwords must be at least 8 characters </small></div>");
	            return "registration-page.jsp";
	    	}
	    	boolean isDuplicate = userService.checkDuplicateUser(user.getEmail());
	        if(isDuplicate) {
	            model.addAttribute("emailError", "<div class='col-12'><small>This Email is already in use! Try a different email address</small><small> or login</small><a class='small' href='/'> here</a></div>");
	            return "registration-page.jsp";
	        }
	        boolean passwordsMatch = userService.checkPasswordMatch(user.getPassword(),user.getPasswordConfirmation());
	        if(passwordsMatch) {
	        	model.addAttribute("passwordConfirmationError", "<div class='col-12'><small>Passwords must match!</small></div>");
	            return "registration-page.jsp";
	        }
	        User userObject = userService.registerUser(user);
	        session.setAttribute("userId", userObject.getId());
	        return "redirect:/home";
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(
	    		@RequestParam("email") String email, 
	    		@RequestParam("password") String password, 
	    		Model model, 
	    		HttpSession session
	    		) {
	    	boolean isDuplicate = userService.checkDuplicateUser(email);
	        if(!isDuplicate) {
	        	model.addAttribute("error", "<label class='Small text-danger'> The email you entered isn’t connected to an account.</label><a href='/registration'>Resgister a new Account</a>");
	            return "login-page.jsp";
	        }
	    	if (userService.authenticateUser(email, password)) {
	            session.setAttribute("userId", userService.findByEmail(email).getId());
	            session.setAttribute("login", true);
	            return "redirect:/home";
	        } else {
	        	model.addAttribute("userEmail", email);
	            model.addAttribute("error", "<label class='Small text-danger'>Oh Snap! Check the password and try again</label>");
	            return "login-page.jsp";
	        }
	    }
	    
	    @RequestMapping("/home")
	    public String home(
	    		HttpSession session, 
	    		Model model
	    		) {
	    	String action = "redirect:/";
	    	try {
	    		Object userId = session.getAttribute("userId");
	    		if((Long) userId > 0) {
	    			User user = userService.findUserById((Long)userId);
	    			model.addAttribute("user",user);
	    			action = "homePage.jsp";
	    		};
			} catch (Exception e) {
			     action = "redirect:/";
			}
			return action;
	        // get user from session, save them in the model and return the home page
	    }
	    @RequestMapping("/logout")
	    public String logout(
	    		HttpSession session
	    		) {
	        session.invalidate();
	        return "redirect:/";
	    }
}
