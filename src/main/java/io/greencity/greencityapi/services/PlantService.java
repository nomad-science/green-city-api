package io.greencity.greencityapi.services;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greencity.greencityapi.mapping.interfaces.PlantMapper;
import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.models.beans.SearchResult;
import io.greencity.greencityapi.repositories.PlantRepository;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepo;

    @Autowired
    private PlantMapper plantMapper;

    public SearchResult<Plant> getPlants() {
        SearchResult<Plant> allPlantsResults = new SearchResult<>();
        List<Plant> allResults = new ArrayList<>();
        Optional<List<PlantDto>> allPlants = Optional.ofNullable(plantRepo.findAll());
        if (allPlants.isPresent()) {
            allResults = allPlants.get().stream().map(plantDto -> plantMapper.plantDtoToPlant(plantDto))
                    .collect(Collectors.toList());
        }

        allPlantsResults.setResults(allResults);
        return allPlantsResults;

    }

    public SearchResult<Plant> getPlantByScientificName(String plantName) {
        SearchResult<Plant> searchResult = new SearchResult<>();
        List<Plant> resultList = new LinkedList<>();

        Optional<PlantDto> plantSearchResult = Optional.ofNullable(plantRepo.findByScientificName(plantName));
        if (plantSearchResult.isPresent()) {
            resultList.add(plantMapper.plantDtoToPlant(plantSearchResult.get()));
        }

        searchResult.setResults(resultList);
        return searchResult;
    }

}
