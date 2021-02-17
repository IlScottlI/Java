package com.codingdojo.johnson.se;


import java.text.FieldPosition;
import java.text.SimpleDateFormat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

@SpringBootApplication
@Controller
public class DisplaydateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplaydateApplication.class, args);
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("date", new java.util.Date());
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEE, 'the' dd 'of' MMMMM, yyyy");
		String date = simpleDateFormat.format(new java.util.Date());
		model.addAttribute("date", date);
		return "date.jsp";
	}
}
