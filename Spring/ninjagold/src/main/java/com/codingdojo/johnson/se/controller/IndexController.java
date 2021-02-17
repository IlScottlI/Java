package com.codingdojo.johnson.se.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.johnson.se.services.Entry;


@Controller
public class IndexController {
	public List<Entry> entries = new ArrayList<>();
	public int total = 0;
    @RequestMapping("/")
    public String index(Model model) {
        for (Entry entry : entries) {
            System.out.println(entry.string());
        }
        model.addAttribute("entries", entries);
        model.addAttribute("total", total);
        return "index.jsp";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String process(@RequestParam(value = "type") String location) {
    	int amount;
    	switch (location) {
		case "farm":
			amount = this.generateRandom(10, 20);
			entries.add(new Entry(location,amount,"success"));
			total = total + amount;
			break;
		case "cave":
			amount = this.generateRandom(5, 10);
			entries.add(new Entry(location,amount,"success"));
			total = total + amount;
			break;
		case "house":
			amount = this.generateRandom(2, 5);
			entries.add(new Entry(location,amount,"success"));
			total = total + amount;
			break;
		case "casino":
			amount = this.generateRandom(-50, 50);
			String sign;
			if(amount >= 0) {
				sign = "success";
				total = total + amount;
			} else {
				sign = "danger";
				total = total - amount;
			}
			entries.add(new Entry(location,amount,sign));
			break;
		}
        return "redirect:/";
    }
    
    public int generateRandom(int start, int end) {
	    Random r = new Random();
        return r.nextInt(end-start) + start;
    }
}
