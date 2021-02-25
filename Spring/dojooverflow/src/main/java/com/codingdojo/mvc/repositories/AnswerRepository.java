package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer,Long> {
	List<Answer> findAll();
	List<Answer> findAll(Sort sortOrder);
}
