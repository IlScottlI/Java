package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.repositories.QuestionRepository;

@Service
public class QuestionService {

	 private final QuestionRepository questionRepository;
	    
	    public QuestionService(QuestionRepository questionRepository) {
	        this.questionRepository = questionRepository;
	    }

	    public List<Question> allItems() {
	        return questionRepository.findAll();
	    }
	    
	    public Question createItem(Question item) {
	        return questionRepository.save(item);
	    }
	    
	    public Question updateItem(Question item) {
	        return questionRepository.save(item);
	    }


	    public Question findItem(Long id) {
	        Optional<Question> optionalItem = questionRepository.findById(id);
	        if(optionalItem.isPresent()) {
	        	 return optionalItem.get();
	        } else {
	        	return null;
	        }
	    }   

		public void deleteItem(Long id) {
			questionRepository.deleteById(id);		
		}

		public List<Question> findAll(Sort sortOrder) {
			return questionRepository.findAll(sortOrder);
		}
		
}
