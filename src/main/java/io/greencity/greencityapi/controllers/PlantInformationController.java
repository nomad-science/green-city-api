package io.greencity.greencityapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.services.PlantService;

@Controller
@RequestMapping(value = "/v1/plants")
public class PlantInformationController {

    @Autowired
    private PlantService service;

    @GetMapping("")
    public ResponseEntity<List<Plant>> getPlantResults() {
        List<Plant> results = service.getPlants();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{plantName}")
    public ResponseEntity<Plant> getSpecificPlant(@PathVariable String plantName) {
        return ResponseEntity.ok(service.getPlantByScientificName(plantName));
    }

}
