package com.mkraskiewicz.petclinic.repositories;

import com.mkraskiewicz.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
