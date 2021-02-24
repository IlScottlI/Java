package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Category;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Long>{
    List<Category> findAll();
    List<Category> findAll(Sort sortOrder);
}

