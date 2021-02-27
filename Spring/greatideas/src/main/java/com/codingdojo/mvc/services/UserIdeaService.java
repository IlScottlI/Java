package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.UserIdea;
import com.codingdojo.mvc.repositories.UserIdeaRepository;

@Service
public class UserIdeaService {
private final UserIdeaRepository userIdeaRepository;
    
    public UserIdeaService(UserIdeaRepository userIdeaRepository) {
        this.userIdeaRepository = userIdeaRepository;
    }

    public List<UserIdea> allItems() {
        return userIdeaRepository.findAll();
    }
    
    public UserIdea createItem(UserIdea item) {
        return userIdeaRepository.save(item);
    }

    public UserIdea findItem(Long id) {
    	Optional<UserIdea> optionalItem = userIdeaRepository.findById(id);
        if(optionalItem.isPresent()) {
        	 return optionalItem.get();
        } else {
        	return null;
        }
    }   

	public void deleteItem(Long id) {
		userIdeaRepository.deleteById(id);		
	}

	public List<UserIdea> findAll(Sort sortOrder) {
		return userIdeaRepository.findAll(sortOrder);
	}
}
