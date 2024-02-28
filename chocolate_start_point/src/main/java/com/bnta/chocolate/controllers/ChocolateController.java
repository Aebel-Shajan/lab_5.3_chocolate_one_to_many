package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public  ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> percentage) {
        List<Chocolate> chocolates;
        if(percentage.isPresent()){
            chocolates =  chocolateService.getCocoaPercentageGreaterThan(percentage.get());
            return new ResponseEntity<>(chocolates, HttpStatus.OK);
        }
        return new ResponseEntity<>(chocolateService.getAllChocolates(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getById(@PathVariable long id){
       Chocolate chocolate = chocolateService.getById(id).get();
       return new ResponseEntity<>(chocolate, HttpStatus.OK);
    }

    @GetMapping(value = "/cocoa")
    public ResponseEntity<List<Chocolate>> getCocoaPercentageGreaterThan(@RequestParam int percentage) {
        return new ResponseEntity<>(chocolateService.getCocoaPercentageGreaterThan(percentage), HttpStatus.OK);
    }

        @PostMapping("/newChocolate")
        public ResponseEntity<Chocolate> addChocolate(@RequestBody ChocolateDTO chocolateDTO){
        Chocolate  chocolate = chocolateService.addNewChocolate(chocolateDTO);
        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }


}
