package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @PostMapping
    public ResponseEntity<Chocolate> addNewChocolate(@RequestBody Chocolate chocolate){
        chocolateService.saveChocolate(chocolate);
        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Chocolate>> getAllChocolates() {
        return new ResponseEntity<>(chocolateService.getAllChocolates(), HttpStatus.OK);
    }



}
