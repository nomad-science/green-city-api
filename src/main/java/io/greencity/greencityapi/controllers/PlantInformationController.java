package io.greencity.greencityapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.services.PlantService;

import io.greencity.greencityapi.models.beans.SearchResult;

@Controller
@RequestMapping(value = "/v1/plants")
public class PlantInformationController {

    @Autowired
    private PlantService service;

    @GetMapping("")
    public ResponseEntity<SearchResult<Plant>> getPlantResults() {
        SearchResult<Plant> allPlants = service.getPlants();
        return new ResponseEntity<>(allPlants, allPlants.getStatusCode());
    }

    @GetMapping("/{plantName}")
    public ResponseEntity<SearchResult<Plant>> getSpecificPlant(@PathVariable String plantName) {
        SearchResult<Plant> plantSearchResult = service.getPlantByScientificName(plantName);
        return new ResponseEntity<>(plantSearchResult, plantSearchResult.getStatusCode());
    }

}
