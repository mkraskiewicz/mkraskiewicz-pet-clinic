package com.mkraskiewicz.petclinic.repositories;

import com.mkraskiewicz.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
