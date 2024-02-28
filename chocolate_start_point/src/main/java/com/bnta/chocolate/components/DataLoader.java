package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Estate estate1 = new Estate("Cadbury Estate", "UK");
        Estate estate2 = new Estate("Hershey Estate", "US");
        Estate estate3 = new Estate("Fererro Estate", "Italy");

        Chocolate chocolate1 = new Chocolate("Cadbury bar", 20, estate1);
        Chocolate chocolate2 = new Chocolate("Hershey bar", 60, estate2);
        Chocolate chocolate3 = new Chocolate("Kinder egg", 70, estate3);

        estateService.saveEstate(estate1);
        estateService.saveEstate(estate2);
        estateService.saveEstate(estate3);

        chocolateService.saveChocolate(chocolate1);
        chocolateService.saveChocolate(chocolate2);
        chocolateService.saveChocolate(chocolate3);
    }
}
