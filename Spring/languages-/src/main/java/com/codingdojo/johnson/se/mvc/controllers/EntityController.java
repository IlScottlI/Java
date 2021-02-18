package com.codingdojo.johnson.se.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.johnson.se.mvc.models.Entitym;
import com.codingdojo.johnson.se.mvc.services.EntityService;

@Controller
public class EntityController {
    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Entitym entity = entityService.findEntity(id);
        model.addAttribute("entity", entity);
        return "/languages/edit.jsp";
    }

    @RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("entity") Entitym entity, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            entityService.updateEntity(entity);
            return "redirect:/languages";
        }
    }

    @RequestMapping("/languages/new")
    public String newEntity(@ModelAttribute("entity") Entitym entity) {
        return "/languages/new.jsp";
    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("entity") Entitym entity, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/new.jsp";
        } else {
            entityService.createEntity(entity);
            return "redirect:/languages";
        }
    }

    @RequestMapping("/languages")
    public String viewEnties(Model model) {
        List<Entitym> entities = entityService.allEntities();
        model.addAttribute("entities", entities);
        return "/languages/view.jsp";
    }

    @RequestMapping("/languages/{id}")
    public String showEntity(@PathVariable("id") Long id, Model model) {
        Entitym entity = entityService.findEntity(id);
        model.addAttribute("entity", entity);
        return "/languages/show.jsp";
    }

    @RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        entityService.deleteEntity(id);
        return "redirect:/languages";
    }

}