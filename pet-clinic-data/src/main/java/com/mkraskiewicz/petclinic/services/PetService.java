package com.mkraskiewicz.petclinic.services;

import com.mkraskiewicz.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
