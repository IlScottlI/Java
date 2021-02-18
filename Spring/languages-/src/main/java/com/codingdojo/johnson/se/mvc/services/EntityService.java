package com.codingdojo.johnson.se.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.johnson.se.mvc.models.Entitym;
import com.codingdojo.johnson.se.mvc.repositories.EntityRepository;

@Service
public class EntityService {

    private final EntityRepository entityRepository;

    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    // returns all the entities
    public List<Entitym> allEntities() {
        return entityRepository.findAll();
    }

    // creates a entity
    public Entitym createEntity(Entitym b) {
        return entityRepository.save(b);
    }

    // retrieves a entity
    public Entitym findEntity(Long id) {
        Optional<Entitym> optionalEntity = entityRepository.findById(id);
        if (optionalEntity.isPresent()) {
            return optionalEntity.get();
        } else {
            return null;
        }
    }

    // retrieves a entity and updates
    public Entitym updateEntity(Entitym entity) {
        return entityRepository.save(entity);
    }

    public void deleteEntity(Long id) {
        entityRepository.deleteById(id);
    }
}