package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Idea;
import com.codingdojo.mvc.repositories.IdeaRepository;

@Service
public class IdeaService {
	 private final IdeaRepository ideaRepository;
	    
	    public IdeaService(IdeaRepository ideaRepository) {
	        this.ideaRepository = ideaRepository;
	    }

	    public List<Idea> allItems() {
	        return ideaRepository.findAll();
	    }
	    
	    public Idea createItem(Idea item) {
	        return ideaRepository.save(item);
	    }

	    public Idea findItem(Long id) {
	    	Optional<Idea> optionalItem = ideaRepository.findById(id);
	        if(optionalItem.isPresent()) {
	        	 return optionalItem.get();
	        } else {
	        	return null;
	        }
	    }   

		public void deleteItem(Long id) {
			ideaRepository.deleteById(id);		
		}

		public List<Idea> findAll(Sort sortOrder) {
			return ideaRepository.findAll(sortOrder);
		}
		
}
