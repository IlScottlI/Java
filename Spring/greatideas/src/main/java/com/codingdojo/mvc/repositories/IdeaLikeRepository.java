package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.IdeaLikes;

public interface IdeaLikeRepository extends CrudRepository<IdeaLikes, Long>{
	List<IdeaLikes> findAll();
	List<IdeaLikes> findAll(Sort sortOrder);
	List<IdeaLikes> findAllByIdeaId(Long id);
}

