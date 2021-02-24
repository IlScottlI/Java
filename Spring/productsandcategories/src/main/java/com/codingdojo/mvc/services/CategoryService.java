package com.codingdojo.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.repositories.CategoriesRepository;

@Service
public class CategoryService {
	 private final CategoriesRepository categoriesRepository;
	    
	    public CategoryService(CategoriesRepository categoriesRepository) {
	        this.categoriesRepository = categoriesRepository;
	    }

	    public List<Category> allItems() {
	        return categoriesRepository.findAll();
	    }
	    
	    public Category createItem(Category ninja) {
	        return categoriesRepository.save(ninja);
	    }

	    public Category findItem(Long id) {
	        Optional<Category> optionalItem = categoriesRepository.findById(id);
	        if(optionalItem.isPresent()) {
	        	 return optionalItem.get();
	        } else {
	        	return null;
	        }
	    }   

		public void deleteItem(Long id) {
			categoriesRepository.deleteById(id);		
		}

		public List<Category> findAll(Sort sortOrder) {
			return categoriesRepository.findAll(sortOrder);
		}
		
		public List<Category> getUnused(List<Category> categoryProducts) {
			List<Category> filtered = new ArrayList<Category>();
			for (Iterator<Category> iterator = categoriesRepository.findAll().iterator(); iterator.hasNext();) {
				Category category = (Category) iterator.next();
				if(!categoryProducts.contains(category)) {
					filtered.add(category);
				};				
			}
			return filtered;
		}

	
}
