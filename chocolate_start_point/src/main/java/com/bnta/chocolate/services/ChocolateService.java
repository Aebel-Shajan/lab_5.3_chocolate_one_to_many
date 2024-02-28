package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public Chocolate saveChocolate(Chocolate chocolate) {
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    public List<Chocolate> getAllChocolates() {
        return chocolateRepository.findAll();
    }

    public Optional<Chocolate> getById(long id){
        return chocolateRepository.findById(id);
    }

    public List<Chocolate> getCocoaPercentageGreaterThan(int percentage) {
        return chocolateRepository.findByCocoaPercentageGreaterThan(percentage);
    }

}
