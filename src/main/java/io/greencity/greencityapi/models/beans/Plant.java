package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Plant {

    private Long id;
    private String scientificName;
    private String commonNames;
    private String locale;
    private String countries;
    private String statesOrProvinces;
    private String citiesOrTowns;
    private String shortDescription;
    private String longDescription;
    private float height;
    private float width;
    private String image;
    private String hardinessZones;
    private int soilPh;
    private String soilType;
    private String neededNutrients;
    private String neededAmountOfSun;
    private String plantingSeasons;
    private String medicinalUses;
    private String edible;

}
