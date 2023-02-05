package io.greencity.greencityapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greencity.greencityapi.mapping.interfaces.PlantMapper;
import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.repositories.PlantRepository;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepo;

    @Autowired
    private PlantMapper plantMapper;

    public List<Plant> getPlants() {
        List<PlantDto> allPlants = plantRepo.findAll();
        return allPlants.stream().map(plantDto -> plantMapper.plantDtoToPlant(plantDto)).collect(Collectors.toList());

    }

    public Plant getPlantByScientificName(String plantName) {
        return plantMapper.plantDtoToPlant(plantRepo.findByScientificName(plantName));
    }

}
