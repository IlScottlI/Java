package com.codingdojo.johnson.se.controllers;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	public String getErrorAlert(String error) {
		return "<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\r\n"
				+ "					<button type=\"button\" class=\"close\" data-dismiss=\"alert\" >\r\n"
				+ "						<small aria-hidden=\"true\">x</small>\r\n"
				+ "					</button>\r\n"
				+ "			<span class=\"text-nowrap\">\r\n"
				+ "				<strong>\r\n"
				+ "					"+ error +"\r\n"
				+ "				</strong>\r\n"
				+ "			</span>\r\n"
				+ "		</div>";
	}
	
	public String getSuccessAlert(String message) {
		return "<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\r\n"
				+ "					<button type=\"button\" class=\"close\" data-dismiss=\"alert\" >\r\n"
				+ "						<small aria-hidden=\"true\">x</small>\r\n"
				+ "					</button>\r\n"
				+ "			<span class=\"text-nowrap\">\r\n"
				+ "				<strong>\r\n"
				+ "					"+ message +"\r\n"
				+ "				</strong>\r\n"
				+ "			</span>\r\n"
				+ "		</div>";
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("errorStyle", "display:none;");
		return "index.jsp";
	}
	
	@RequestMapping("/code")
	public String code(Model model) {
		model.addAttribute("errorStyle", "display:none;");
		return "code.jsp";
	}
	

	@RequestMapping(value="/trycode", method=RequestMethod.POST )
    public String flashMessages(
    		RedirectAttributes redirectAttributes, 
    		Model model, 
    		HttpServletRequest request,
    		@RequestParam(value="code") String code
    		) {
			if(code.equals("bushido")) {
				return "redirect:/code";
			}
		 	if (code.length() > 0) {
		 		redirectAttributes.addFlashAttribute("errormessage", getErrorAlert("You must train harder!"));
			 	return "redirect:/";
		    } else {
		    	redirectAttributes.addFlashAttribute("errormessage",  getErrorAlert("You must provide a value"));
		    	return "redirect:/";
		    }
    }

	
}
