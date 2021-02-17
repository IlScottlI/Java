package com.codingdojo.johnson.se.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index.jsp";
    }

    @RequestMapping("/result")
    public String result(Model model) {
        return "result.jsp";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String flashMessages(
    		Model model, 
    		HttpServletRequest request, 
    		HttpSession session,
    		@RequestParam(value = "name") String name,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "language") String language,
            @RequestParam(value = "comment") String comment
            ) {
    	session.setAttribute("name", name);
    	model.addAttribute(name);
    	session.setAttribute("location", location);
    	model.addAttribute(location);
    	session.setAttribute("language", language);
    	model.addAttribute(language);
    	session.setAttribute("comment", comment);
    	model.addAttribute(comment);
        return "redirect:/result";
    }
}
