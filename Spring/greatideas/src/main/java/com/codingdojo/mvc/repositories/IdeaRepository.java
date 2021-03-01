package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.Idea;


public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
	List<Idea> findAll(Sort sortOrder);
	 @Query("SELECT i FROM Idea i WHERE id = ?1")
	List<Idea> getIdeaWhereUserLiked(Long id);
	List<Idea> findByOrderByLikeCountAsc();
	List<Idea> findByOrderByLikeCountDesc();
}

