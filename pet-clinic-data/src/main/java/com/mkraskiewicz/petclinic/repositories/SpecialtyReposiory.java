package com.mkraskiewicz.petclinic.repositories;

import com.mkraskiewicz.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyReposiory extends CrudRepository<Speciality, Long> {
}
