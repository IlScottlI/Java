package com.codingdojo.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.models.TagQuestion;
import com.codingdojo.mvc.repositories.TagQuestionRepository;

@Service
public class TagQuestionService {
	 private final TagQuestionRepository tagQuestionRepository;
	    
	    public TagQuestionService(TagQuestionRepository tagQuestionRepository) {
	        this.tagQuestionRepository = tagQuestionRepository;
	    }

	    public List<TagQuestion> allItems() {
	        return tagQuestionRepository.findAll();
	    }
	    
	    public TagQuestion createItem(TagQuestion item) {
	        return tagQuestionRepository.save(item);
	    }

	    public TagQuestion findItem(Long id) {
	    	Optional<TagQuestion> optionalItem = tagQuestionRepository.findById(id);
	        if(optionalItem.isPresent()) {
	        	 return optionalItem.get();
	        } else {
	        	return null;
	        }
	    }   
	    
	    public List<TagQuestion> associateItems(List<Tag> tagList, Question question) {
	    	List<TagQuestion> tagQuestionList = new ArrayList<TagQuestion>();
	    	for (Iterator<Tag> iterator = tagList.iterator(); iterator.hasNext();) {
				Tag tag = (Tag) iterator.next();
				TagQuestion tagQuestion = new TagQuestion();
				tagQuestion.setQuestion(question);
				tagQuestion.setTag(tag);
				tagQuestionList.add(tagQuestion);
				}
	    		return tagQuestionList;
	    }
	    
		public void deleteItem(Long id) {
			tagQuestionRepository.deleteById(id);		
		}

		public List<TagQuestion> findAll(Sort sortOrder) {
			return tagQuestionRepository.findAll(sortOrder);
		}

}
