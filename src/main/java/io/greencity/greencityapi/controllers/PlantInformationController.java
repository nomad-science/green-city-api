package io.greencity.greencityapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.services.PlantService;

@Controller
@RequestMapping(value = "/v1/plants")
public class PlantInformationController {

    @Autowired
    private PlantService service;

    @GetMapping("")
    public ResponseEntity<Iterable<PlantDto>> getPlantResults() {
        Iterable<PlantDto> results = service.getPlants();

        return ResponseEntity.ok(results);
    }

}
