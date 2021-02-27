package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Like;
import com.codingdojo.mvc.repositories.LikeRepository;

@Service
public class LikeService {
	private final LikeRepository likeRepository;
    
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<Like> allItems() {
        return likeRepository.findAll();
    }
    
    public Like createItem(Like item) {
        return likeRepository.save(item);
    }

    public Like findItem(Long id) {
    	Optional<Like> optionalItem = likeRepository.findById(id);
        if(optionalItem.isPresent()) {
        	 return optionalItem.get();
        } else {
        	return null;
        }
    }   

	public void deleteItem(Long id) {
		likeRepository.deleteById(id);		
	}

	public List<Like> findAll(Sort sortOrder) {
		return likeRepository.findAll(sortOrder);
	}
}
