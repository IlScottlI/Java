package com.codingdojo.johnson.se.controllerspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ControllerspracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerspracticeApplication.class, args);
	}

    @RequestMapping("/world")
    public String world() {
            return "Class level annotations are cool too!";
    }
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}

}
