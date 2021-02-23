package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.repositories.NinjaRepository;
@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
        	 return optionalNinja.get();
        } else {
        	return null;
        }
    }   

	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);		
	}

	public List<Ninja> findAll(Sort sortOrder) {
		return ninjaRepository.findAll(sortOrder);
	}
}
