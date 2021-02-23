package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.repositories.DojoRepository;
@Service
public class DojoService {
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
        	 return optionalDojo.get();
        } else {
        	return null;
        }
    }
    

	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);		
	}

	public List<Dojo> findAll(Sort sortOrder) {
		return dojoRepository.findAll(sortOrder);
	}
}
