package com.mkraskiewicz.petclinic.bootstrap;


import com.mkraskiewicz.petclinic.model.*;
import com.mkraskiewicz.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if( count == 0 ){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Grzegorz");
        owner1.setLastName("Kowalski");
        owner1.setAddress("123 SomeStreet");
        owner1.setCity("Lodz");
        owner1.setTelephone("1234567890");

        Pet grzegorzPet = new Pet();
        grzegorzPet.setPetType(savedDogPetType);
        grzegorzPet.setOwner(owner1);
        grzegorzPet.setBirthDate(LocalDate.now());
        grzegorzPet.setName("Rosco");
        owner1.getPets().add(grzegorzPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Janusz");
        owner2.setLastName("Nowak");
        owner2.setAddress("123 DifferentStreet");
        owner2.setCity("Warsaw");
        owner2.setTelephone("0987654321");

        Pet januszPet = new Pet();
        januszPet.setPetType(savedCatPetType);
        januszPet.setBirthDate(LocalDate.now());
        januszPet.setName("Normal Cat");
        januszPet.setOwner(owner2);
        owner2.getPets().add(januszPet);
        ownerService.save(owner2);

        Visit januszVisit = new Visit();
        januszVisit.setPet(januszPet);
        januszPet.getVisits().add(januszVisit);
        januszVisit.setDate(LocalDate.now());
        januszVisit.setDescription("Sneezy kitty");

        visitService.save(januszVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Natalia");
        vet1.setLastName("Testowa");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Oktawiusz");
        vet2.setLastName("Nowoczesny");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
