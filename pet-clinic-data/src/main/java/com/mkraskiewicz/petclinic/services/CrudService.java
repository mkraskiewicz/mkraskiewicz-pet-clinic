package com.mkraskiewicz.petclinic.services;

import javax.persistence.Id;
import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();
    T findById(Id id);
    T save(T object);
    void delete(T object);
    void deleteById(Id id);
}
