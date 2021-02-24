package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product,Long> {
	 List<Product> findAll();
	 List<Product> findAll(Sort sortOrder);
}
