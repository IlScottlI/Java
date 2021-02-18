package com.codingdojo.johnson.se.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.johnson.se.mvc.models.Entitym;
import com.codingdojo.johnson.se.mvc.services.EntityService;

@RestController
public class EntityApi {
    private final EntityService entityService;

    public EntityApi(EntityService entityService) {
        this.entityService = entityService;
    }

    @RequestMapping("/api/languages")
    public List<Entitym> index() {
        return entityService.allEntities();
    }

    @RequestMapping(value = "/api/languages", method = RequestMethod.POST)
    public Entitym create(
    		@RequestParam(value = "name") String name, 
    		@RequestParam(value = "creator") String creator,
            @RequestParam(value = "currentVersion") String currentVersion
            ) {
        Entitym entity = new Entitym(name, creator, currentVersion);
        return entityService.createEntity(entity);
    }

    @RequestMapping("/api/languages/{id}")
    public Entitym show(@PathVariable("id") Long id) {
        Entitym entity = entityService.findEntity(id);
        return entity;
    }

    @RequestMapping(value = "/api/languages/{id}", method = RequestMethod.PUT)
    public Entitym update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value = "name") String name,
            @RequestParam(value = "creator") String creator,
            @RequestParam(value = "currentVersion") String currentVersion) {
        Entitym entity = entityService.findEntity(id);
        if (!entity.equals(null)) {
            entity.setName(name);
            entity.setCreator(creator);
            entity.setCurrentVersion(currentVersion);
            entityService.updateEntity(entity);
        }
        return entity;
    }

    @RequestMapping(value = "/api/languages/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        entityService.deleteEntity(id);
    }
}
