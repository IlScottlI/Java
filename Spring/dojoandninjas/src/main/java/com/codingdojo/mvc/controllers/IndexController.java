package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.services.DojoService;
import com.codingdojo.mvc.services.NinjaService;

@Controller
public class IndexController {
	
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public IndexController( DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        List<Ninja> ninjas = ninjaService.allNinjas();
        model.addAttribute("dojos", dojos);
        model.addAttribute("ninjas", ninjas);
        return "all-dojos.jsp";
    }
    
    @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo,Model model) {
        return "new-dojo.jsp";
    }
    
    @RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "new-dojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/dojos/{id}")
    public String viewDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "view-dojos.jsp";
    }
    
    @RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
    	List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "new-ninja.jsp";
    }
    
    @RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
            model.addAttribute("dojos", dojos);
            return "new-ninja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/";
        }
    }
    
    
}