package com.bnta.chocolate.models;

public class ChocolateDTO {
    private String name;
    private int cocoaPercentage;
    private int estateId;


    public ChocolateDTO(String name, int cocoaPercentage, int estateId) {
        this.name = name;
        this.cocoaPercentage = cocoaPercentage;
        this.estateId = estateId;
    }

    public ChocolateDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }
}
