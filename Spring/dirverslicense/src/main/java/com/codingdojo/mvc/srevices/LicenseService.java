package com.codingdojo.mvc.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.License;
import com.codingdojo.mvc.repositories.LicenseRepository;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;
    
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
    
    public License createLicense(License license) {
    	int count = (int) licenseRepository.count();
    	String formatted = String.format("%06d", count + 1);
    	license.setNumber(formatted);
        return licenseRepository.save(license);
    }

    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
        	 return optionalLicense.get();
        } else {
        	return null;
        }
       
    }   

	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);		
	}

	public List<License> findAll(Sort sortOrder) {
		return licenseRepository.findAll(sortOrder);
	}
}
