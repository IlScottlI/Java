package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
    List<License> findAll(Sort sortOrder);
}
