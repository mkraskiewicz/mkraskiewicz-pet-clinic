package com.mkraskiewicz.petclinic.services;

import com.mkraskiewicz.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
