package io.greencity.greencityapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greencity.greencityapi.mapping.interfaces.PlantMapper;
import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.models.beans.SearchResult;
import io.greencity.greencityapi.repositories.PlantRepository;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepo;

    @Autowired
    private PlantMapper plantMapper;

    public SearchResult getPlants() {
        SearchResult allPlantsResults = new SearchResult();
        Optional<List<PlantDto>> allPlants = Optional.ofNullable(plantRepo.findAll());
        if (allPlants.isPresent()) {
            allPlantsResults.setResults(plantMapper.convertDtosList(allPlants.get().stream()));
        }

        return allPlantsResults;

    }

    public SearchResult getPlantByScientificName(String plantName) {
        SearchResult searchResult = new SearchResult();

        Optional<PlantDto> plantSearchResult = Optional.ofNullable(plantRepo.findByScientificName(plantName));
        if (plantSearchResult.isPresent()) {
            searchResult.setResults(plantMapper.convertDto(plantSearchResult.get()));
        }

        return searchResult;
    }
}
