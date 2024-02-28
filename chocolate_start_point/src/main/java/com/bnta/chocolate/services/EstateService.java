package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class EstateService {

    @Autowired
    EstateRepository estateRepository;

    public Estate saveEstate(Estate estate){
        estateRepository.save(estate);
        return estate;
    }

    public List<Estate> getAllEstates() {
        return estateRepository.findAll();
    }

    public Optional<Estate> getById(long id){
        return estateRepository.findById(id);
    }

}
