package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.Idea;
import com.codingdojo.mvc.models.Like;

public interface LikeRepository extends CrudRepository<Like, Long> {
	List<Like> findAll();
	List<Like> findAll(Sort sortOrder);
	List<Like> findByIdea(Idea idea);
}
