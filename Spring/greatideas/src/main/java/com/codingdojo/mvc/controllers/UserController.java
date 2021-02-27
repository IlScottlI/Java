package com.codingdojo.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Idea;
import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.services.IdeaService;
import com.codingdojo.mvc.services.UserService;

@Controller
public class UserController {
	 private final UserService userService;
	 private final IdeaService ideaService;
	    public UserController(
	    		UserService userService,
	    		IdeaService ideaService
	    		) {
	        this.userService = userService;
	        this.ideaService = ideaService;
	    }
	    
	    
	    @RequestMapping("/")
	    public String login(
	    		@Valid @ModelAttribute("user") User user,
	    		HttpSession session,
	    		Model model
	    		) {
	    	int counter = 0;
        	String error = (String) session.getAttribute("error");
        	model.addAttribute("error",error);
    		if (session.getAttribute("counter") != null) {
    			counter = (int) session.getAttribute("counter");
    			session.setAttribute("counter", counter + 1);
    		} else {
    			session.setAttribute("counter", counter);
    		}
    		if (counter > 0) {
				session.invalidate();
			}
	        return "login-registration.jsp";
	    }
	    
	    @RequestMapping(value="/", method=RequestMethod.POST)
	    public String registerUser(
	    		@Valid @ModelAttribute("user") User user, 
	    		BindingResult result, 
	    		HttpSession session,
	    		Model model
	    		) {
	    	
	    	if (result.hasErrors()) {
	    		return "login-registration.jsp";
			} 
	    	boolean passwordLength = userService.checkPasswordLength(user.getPassword());
	    	if(passwordLength) {
	    		model.addAttribute("passwordError", "<div class='col-12'><small>Passwords must be at least 8 characters </small></div>");
	            return "login-registration.jsp";
	    	}
	    	passwordLength = userService.checkPasswordLength(user.getPasswordConfirmation());
	    	if(passwordLength) {
	    		model.addAttribute("passwordConfirmationError", "<div class='col-12'><small>Passwords must be at least 8 characters </small></div>");
	            return "login-registration.jsp";
	    	}
	    	boolean isDuplicate = userService.checkDuplicateUser(user.getEmail());
	        if(isDuplicate) {
	            model.addAttribute("emailError", "<div class='col-12'><small>This Email is already in use! Try a different email address</small><small> or login</small></div>");
	            return "login-registration.jsp";
	        }
	        boolean passwordsMatch = userService.checkPasswordMatch(user.getPassword(),user.getPasswordConfirmation());
	        if(passwordsMatch) {
	        	model.addAttribute("passwordConfirmationError", "<div class='col-12'><small>Passwords must match!</small></div>");
	            return "login-registration.jsp";
	        }
	        User userObject = userService.registerUser(user);
	        session.setAttribute("userId", userObject.getId());
	        return "redirect:/ideas";
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(
	    		@RequestParam("email") String email, 
	    		@RequestParam("password") String password,
	    		@Valid @ModelAttribute("user") User user, 
	    		Model model, 
	    		HttpSession session
	    		) {
	    	boolean isDuplicate = userService.checkDuplicateUser(email);
	        if(!isDuplicate) { 	        	
	        	session.setAttribute("error", "<label class='Small text-danger'> The email you entered isn’t connected to an account.</label>");
	        	return "redirect:/";
	        }
	    	if (userService.authenticateUser(email, password)) {
	            session.setAttribute("userId", userService.findByEmail(email).getId());
	            session.setAttribute("login", true);	            
	            return "redirect:/ideas";
	        } else {
	        	session.setAttribute("error", "<label class='Small text-danger m-0 p-0'>Oh Snap! That password is not correct</label>");
	            return "redirect:/";
	        }
	    }
	    
	    @RequestMapping("/ideas")
	    public String home(
	    		HttpSession session, 
	    		Model model
	    		) {
	    	String action = "redirect:/";
	    	List<Idea> ideas = ideaService.allItems();
	    	model.addAttribute("ideas",ideas);
	    	ideas.get(0).getLikes().size();
	    	try {
	    		Object userId = session.getAttribute("userId");
	    		if((Long) userId > 0) {
	    			User user = userService.findUserById((Long)userId);
	    			model.addAttribute("user",user);
	    			action = "ideas.jsp";
	    		};
			} catch (Exception e) {
			     action = "redirect:/";
			}
			return action;
	        // get user from session, save them in the model and return the home page
	    }
	    @RequestMapping("/ideas/new")
	    public String newIdeaGet(
	    		@Valid @ModelAttribute("idea") Idea idea, 
	    		Model model,
	    		HttpSession session
	    		) {
	    	Object userId = session.getAttribute("userId");
	    	model.addAttribute("user", userService.findUserById((Long) userId));
	        return "ideas-new.jsp";
	    }
	    @RequestMapping(value = "/ideas/new", method = RequestMethod.POST)
	    public String newIdeaPost(
	    		@Valid @ModelAttribute("idea") Idea idea, 
	    		BindingResult result,
	    		@RequestParam(value="userId") String userId,
	    		Model model,
	    		HttpSession session
	    		) {
	        if (result.hasErrors()) {
	        	Object userId1 = session.getAttribute("userId");
		    	model.addAttribute("user", userService.findUserById((Long) userId1));
	            return "ideas-new.jsp";
	        } else {
	        	Long user_id = Long.decode(userId);
	        	User user = userService.findUserById(user_id);
	        	List<User> createdByList = new ArrayList<User>();
	        	createdByList.add(user);
	        	idea.setUsers(createdByList);
	            ideaService.createItem(idea);
	            return "redirect:/ideas";   
	        }
	    }
	    @RequestMapping("/ideas/{id}")
	    public String viewIdeaGet(
	    		@PathVariable("id") Long id,
	    		Model model,
	    		HttpSession session
	    		) {
	    	Object userId = session.getAttribute("userId");
	    	model.addAttribute("user", userService.findUserById((Long) userId));
	    	Idea idea = ideaService.findItem(id);
	    	model.addAttribute("idea",idea);
	        return "ideas-view.jsp";
	    }
	    @RequestMapping("/ideas/{id}/edit")
	    public String viewIdeaGetEdit(
	    		@Valid @ModelAttribute("idea") Idea idea, 
	    		@PathVariable("id") Long id,
	    		Model model,
	    		HttpSession session
	    		) {
	    	Object userId = session.getAttribute("userId");
	    	model.addAttribute("user", userService.findUserById((Long) userId));
	    	Idea ideaEdit = ideaService.findItem(id);
	    	model.addAttribute("ideaEdit",ideaEdit);
	    	ideaEdit.getUsers().get(0).getId();
	        return "ideas-edit.jsp";
	    }

	    @RequestMapping(value = "/ideas/{id}/edit", method = RequestMethod.POST)
	    public String viewIdeaPutEdit(
	    		@Valid @ModelAttribute("idea") Idea idea, 
	    		BindingResult result,
	    		@PathVariable("id") Long id,
	    		Model model,
	    		@RequestParam(value="userId") String userId,
	    		HttpSession session	    		
	    		) {
	    	Long user_id = Long.decode(userId);
	    	User user = userService.findUserById(user_id);
	    	model.addAttribute("user", user);
	    	Idea ideaEdit = ideaService.findItem(id);
	    	model.addAttribute("ideaEdit",ideaEdit);
	    	 if (result.hasErrors()) {
		            return "ideas-edit.jsp";
		        } else {
		        	List<User> createdByList = new ArrayList<User>();
		        	createdByList.add(user);
		        	ideaEdit.setName(idea.getName());
		        	ideaEdit.setUsers(createdByList);
		            ideaService.createItem(ideaEdit);
		            return "redirect:/ideas/"+ ideaEdit.getId();   
		        }
	    }
	    
	    
	    @RequestMapping(value = "/ideas/{id}/delete", method=RequestMethod.POST)
	    public String delete(@PathVariable("id") Long id) {
	    	ideaService.deleteItem(id);
	    	return "redirect:/ideas";
	    }
	    
	    
}
