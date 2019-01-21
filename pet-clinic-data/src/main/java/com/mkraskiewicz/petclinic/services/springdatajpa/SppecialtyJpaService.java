package com.mkraskiewicz.petclinic.services.springdatajpa;

import com.mkraskiewicz.petclinic.model.Speciality;
import com.mkraskiewicz.petclinic.repositories.SpecialtyReposiory;
import com.mkraskiewicz.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SppecialtyJpaService implements SpecialityService {

   private final SpecialtyReposiory specialtyReposiory;

    public SppecialtyJpaService(SpecialtyReposiory specialtyReposiory) {
        this.specialtyReposiory = specialtyReposiory;
    }

    @Override
    public Set<Speciality> findAll() {

        Set<Speciality> specialities = new HashSet<>();
        specialtyReposiory.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyReposiory.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyReposiory.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyReposiory.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyReposiory.deleteById(aLong);
    }
}
