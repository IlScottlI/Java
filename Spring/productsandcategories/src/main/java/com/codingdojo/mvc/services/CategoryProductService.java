package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.CategoryProduct;
import com.codingdojo.mvc.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	 private final CategoryProductRepository categoryProductRepository;
	    
	    public CategoryProductService(CategoryProductRepository categoryProductRepository) {
	        this.categoryProductRepository = categoryProductRepository;
	    }

	    public List<CategoryProduct> allItems() {
	        return categoryProductRepository.findAll();
	    }
	    
	    public CategoryProduct createItem(CategoryProduct categoryProduct) {
	        return categoryProductRepository.save(categoryProduct);
	    }

	    public CategoryProduct findItem(Long id) {
	        Optional<CategoryProduct> optionalItem = categoryProductRepository.findById(id);
	        if(optionalItem.isPresent()) {
	        	 return optionalItem.get();
	        } else {
	        	return null;
	        }
	    }   

		public void deleteItem(Long id) {
			categoryProductRepository.deleteById(id);		
		}

		public List<CategoryProduct> findAll(Sort sortOrder) {
			return categoryProductRepository.findAll(sortOrder);
		}
}
