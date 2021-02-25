package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.TagQuestion;

public interface TagQuestionRepository extends CrudRepository<TagQuestion, Long> {
	 List<TagQuestion> findAll();
	 List<TagQuestion> findAll(Sort sortOrder);
}
