package com.codingdojo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "<h1>Hello World</h1>");
        return "index.jsp";
    }
}