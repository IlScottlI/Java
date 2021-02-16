package com.codingdojo.johnson.se.familiarwithrouting.cotrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/dojo")
	public String dojo() {
		return "The dojo is awesome!!";
	}
	@RequestMapping("/burbank-dojo/")
	public String dojoBurbank() {
		return "Burbank Dojo is located in Southern California";
	}
	@RequestMapping("/san-jose/")
	public String dojoSanJose() {
		return "SJ dojo is the headquarters";
	}
}
