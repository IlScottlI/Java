package com.codingdojo.johnson.se;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
@RestController
@SpringBootApplication
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}

	 @RequestMapping("/")
     public String index(HttpSession session) { 
		 int counter = 0;
		 if(session.getAttribute("counter") != null) {
			 counter = (int) session.getAttribute("counter");
			 session.setAttribute("counter", counter + 1 );	
		 } else {
			 session.setAttribute("counter", counter );	
		 }		 
             return "<div style='display:flex;justify-content: center;'><h1 style='margin-top:4rem;'>Welcome User!</h1></div>"+
             		"<div style='display:flex;justify-content: flex-end;'><a href='/counter' style='display:flex'>view site counter</a></div>";
     }
	 
	 @RequestMapping("/counter")
     public String counter(HttpSession session) { 
		 int count = 0;
		 if(session.getAttribute("counter") != null){
			 count = (int) session.getAttribute("counter");
		 }
             return "<div style='display:flex'><h1 style='margin-top:4rem;'>You have visited <a href='http://localhost:8080/'>http://localhost:8080/</a> " + count + " times</h1></div>"+
             		"<div><h1><a href='http://localhost:8080/'>Test another visit?</a></h1></div>"+
             		"<div><h1><a href='/clear'>Clear Counter</a></h1></div>";
             
     }
	 
	 @RequestMapping("/clear")
	 public RedirectView clear(HttpSession session, RedirectAttributes redirectAttributes) {
		 session.invalidate();
		 redirectAttributes.addFlashAttribute("error","A test error!");
		 redirectAttributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
		 redirectAttributes.addAttribute("attribute", "redirectWithRedirectView");
	     return new RedirectView("/");
	 }
}
