package com.mkraskiewicz.petclinic.repositories;

import com.mkraskiewicz.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
