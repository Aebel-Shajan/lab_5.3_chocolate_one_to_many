package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @PostMapping
    public ResponseEntity<Estate> addNewEstate(@RequestBody Estate estate){
        estateService.saveEstate(estate);
        return new ResponseEntity<>(estate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates() {
        return new ResponseEntity<>(estateService.getAllEstates(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Estate>> getEstateById(@PathVariable long id) {
        return new ResponseEntity<>(estateService.getById(id), HttpStatus.OK);
    }
}
