package io.greencity.greencityapi.services;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public List<Plant> getPlants() {
        List<PlantDto> allPlants = plantRepo.findAll();
        return allPlants.stream().map(plantDto -> plantMapper.plantDtoToPlant(plantDto)).collect(Collectors.toList());

    }

    public SearchResult<Plant> getPlantByScientificName(String plantName) {
        SearchResult<Plant> searchResult = new SearchResult<>();
        List<Plant> resultList = new LinkedList<>();

        Optional<PlantDto> plantSearchResult = Optional.ofNullable(plantRepo.findByScientificName(plantName));
        if (plantSearchResult.isPresent()) {
            Plant convertedPlantResult = plantMapper.plantDtoToPlant(plantSearchResult.get());
            resultList.add(convertedPlantResult);
            searchResult.setResults(resultList);
            searchResult.setStatusCode(HttpStatus.OK);
        } else {
            searchResult.setStatusCode(HttpStatus.NOT_FOUND);
        }

        searchResult.setResults(resultList);
        return searchResult;
    }

}
