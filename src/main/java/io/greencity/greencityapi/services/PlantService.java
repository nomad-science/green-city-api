package io.greencity.greencityapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.repositories.PlantRepository;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepo;

    public Iterable<PlantDto> getPlants() {
        return plantRepo.findAll();
    }

}
