package com.mkraskiewicz.petclinic.services;

import com.mkraskiewicz.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends  CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
