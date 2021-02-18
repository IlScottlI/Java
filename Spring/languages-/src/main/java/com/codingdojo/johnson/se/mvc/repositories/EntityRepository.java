package com.codingdojo.johnson.se.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.johnson.se.mvc.models.Entitym;

@Repository
public interface EntityRepository extends CrudRepository<Entitym, Long> {
    List<Entitym> findAll();
    List<Entitym> findByNameContaining(String search);
    Long countByNameContaining(String search);
    Long deleteByNameStartingWith(String search);
}
