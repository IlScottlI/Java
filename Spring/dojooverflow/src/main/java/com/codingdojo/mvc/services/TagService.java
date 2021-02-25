package com.codingdojo.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.repositories.TagRepository;

@Service
public class TagService {


	 private final TagRepository tagRepository;
	    
	    public TagService(TagRepository tagRepository) {
	        this.tagRepository = tagRepository;
	    }

	    public List<Tag> allItems() {
	        return tagRepository.findAll();
	    }
	    
	    public List<Tag> createTags(String tags) {
	    	List<Tag> tagList = new ArrayList<Tag>();
	        for (String item : tags.split(",")) {
	            if(findItemsByName(item.trim()).size() < 1) {
	            	Tag tag = new Tag();
	            	tag.setName(item.trim());
	            	createItem(tag);
	            	tagList.add(tag);
	            } else {
	            	Tag tag = (Tag) findItemsByName(item.trim()).get(0);
	            	tagList.add(tag);
	            }
	        }
	        return tagList;
		}
	    public Tag createItem(Tag item) {
	        return tagRepository.save(item);
	    }
	    
	    public List<Tag> findItemsByName(String name) {
	    	List<Tag> items = tagRepository.findAllByName(name);
	      return items;
	    }

	    public Tag findItem(Long id) {
	    	Optional<Tag> optionalItem = tagRepository.findById(id);
	        if(optionalItem.isPresent()) {
	        	 return optionalItem.get();
	        } else {
	        	return null;
	        }
	    }   

		public void deleteItem(Long id) {
			tagRepository.deleteById(id);		
		}

		public List<Tag> findAll(Sort sortOrder) {
			return tagRepository.findAll(sortOrder);
		}
		
		public List<Tag> getUnused(List<Tag> categoryProducts) {
			List<Tag> filtered = new ArrayList<Tag>();
			for (Iterator<Tag> iterator = tagRepository.findAll().iterator(); iterator.hasNext();) {
				Tag product = (Tag) iterator.next();
				if(!categoryProducts.contains(product)) {
					filtered.add(product);
				};				
			}
			return filtered;
		}
}
