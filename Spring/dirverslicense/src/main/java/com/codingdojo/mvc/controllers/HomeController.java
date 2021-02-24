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

import com.codingdojo.mvc.models.License;
import com.codingdojo.mvc.models.Person;
import com.codingdojo.mvc.srevices.PersonService;
import com.codingdojo.mvc.srevices.LicenseService;

import org.springframework.format.annotation.DateTimeFormat;

@Controller
public class HomeController {

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private final PersonService personService;
    private final LicenseService licenseService;

    public HomeController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<License> licenses = licenseService.allLicenses();
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        model.addAttribute("licenses", licenses);
        return "index.jsp";
    }

    // Person Methods

    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new-person.jsp";
    }

    @RequestMapping("/persons/{id}")
    public String viewPerson(@PathVariable("id") Long id, Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "person-profile.jsp";
    }

    @RequestMapping(value = "/persons/new", method = RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "new-person.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/";
        }
    }

    // License Methods

    @RequestMapping("/licenses/new")
    public String newPerson(@ModelAttribute("license") License license, Model model) {
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        return "new-license.jsp";
    }

    @RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("license") License license, BindingResult result) {
        System.out.println(result);
        if (result.hasErrors()) {
            return "new-license.jsp";
        } else {
            licenseService.createLicense(license);
            return "redirect:/";
        }
    }
}
