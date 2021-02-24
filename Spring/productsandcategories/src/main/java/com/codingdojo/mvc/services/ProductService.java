package com.codingdojo.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.repositories.ProductsRepository;

@Service
public class ProductService {

	 private final ProductsRepository productRepository;
	    
	    public ProductService(ProductsRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public List<Product> allItems() {
	        return productRepository.findAll();
	    }
	    
	    public Product createItem(Product ninja) {
	        return productRepository.save(ninja);
	    }

	    public Product findItem(Long id) {
	        Optional<Product> optionalItem = productRepository.findById(id);
	        if(optionalItem.isPresent()) {
	        	 return optionalItem.get();
	        } else {
	        	return null;
	        }
	    }   

		public void deleteItem(Long id) {
			productRepository.deleteById(id);		
		}

		public List<Product> findAll(Sort sortOrder) {
			return productRepository.findAll(sortOrder);
		}
		
		public List<Product> getUnused(List<Product> categoryProducts) {
			List<Product> filtered = new ArrayList<Product>();
			for (Iterator<Product> iterator = productRepository.findAll().iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				if(!categoryProducts.contains(product)) {
					filtered.add(product);
				};				
			}
			return filtered;
		}
}
