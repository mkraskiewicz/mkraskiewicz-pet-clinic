package com.mkraskiewicz.mkraskiewiczpetclinic.model;

import java.time.LocalDate;

/**
 * Created by Maciej on 15/01/2019
 */
public class Pet {

    private PetType petType;
    private Owner owner;
    LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
