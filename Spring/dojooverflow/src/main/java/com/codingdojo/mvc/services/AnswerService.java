package com.codingdojo.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.repositories.AnswerRepository;
@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
    
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> allItems() {
        return answerRepository.findAll();
    }
    
    public Answer createItem(Answer item) {
        return answerRepository.save(item);
    }

    public Answer findItem(Long id) {
        Optional<Answer> optionalItem = answerRepository.findById(id);
        if(optionalItem.isPresent()) {
        	 return optionalItem.get();
        } else {
        	return null;
        }
    }   

	public void deleteItem(Long id) {
		answerRepository.deleteById(id);		
	}

	public List<Answer> findAll(Sort sortOrder) {
		return answerRepository.findAll(sortOrder);
	}
	
	public List<Answer> getUnused(List<Answer> categoryProducts) {
		List<Answer> filtered = new ArrayList<Answer>();
		for (Iterator<Answer> iterator = answerRepository.findAll().iterator(); iterator.hasNext();) {
			Answer product = (Answer) iterator.next();
			if(!categoryProducts.contains(product)) {
				filtered.add(product);
			};				
		}
		return filtered;
	}
}
