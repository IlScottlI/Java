package com.codingdojo.johnson.se.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HumanController {
    @RequestMapping("/")

    public String index(
    		@RequestParam(value="name", required=false, defaultValue="Human") String name,
    		@RequestParam(value="last_name", required=false, defaultValue="") String lastName
    		) {
    	String goBack;
    	switch (name) {
		case "Human":
			goBack = "<div style='display: flex;justify-content: flex-end;margin-right: 4rem'><a href='/'></a></div>";
			break;

		default:
			goBack = "<div style='display: flex;justify-content: flex-end;margin-right: 4rem'><a href='/'>Go Back</a></div>";
			break;
		}
    	String subGreet = "<br><h3 style='margin: 2rem 2rem;'>Welcome to SpringBoot!</h3>";
        return goBack + "<h1 style='margin:2rem'>Hello " + name + " " +  lastName + "</h1>" + subGreet;
    }
}
