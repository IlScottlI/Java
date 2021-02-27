package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.UserIdea;

public interface UserIdeaRepository extends CrudRepository<UserIdea, Long> {
	List<UserIdea> findAll();
	List<UserIdea> findAll(Sort sortOrder);
}
