package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long>{
	List<Tag> findAll();
	List<Tag> findAll(Sort sortOrder);
	List<Tag> findAllByName(String name);
}

