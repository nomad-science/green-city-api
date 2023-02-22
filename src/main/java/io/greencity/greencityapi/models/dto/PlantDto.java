package io.greencity.greencityapi.models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Entity
@Table(name = "plant")
@Component
public class PlantDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "common_names")
    private String commonNames;

    @Column(name = "locale")
    private String locale;

    @Column(name = "countries")
    private String countries;

    @Column(name = "states_or_provinces")
    private String statesOrProvinces;

    @Column(name = "cities_or_towns")
    private String citiesOrTowns;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "height")
    private float height;

    @Column(name = "width")
    private float width;

    @Column(name = "image")
    private String image;

    @Column(name = "hardiness_zones")
    private String hardinessZones;

    @Column(name = "soil_ph")
    private int soilPh;

    @Column(name = "soil_type")
    private String soilType;

    @Column(name = "nutrients")
    private String neededNutrients;

    @Column(name = "amount_of_sun")
    private String neededAmountOfSun;

    @Column(name = "planting_seasons")
    private String plantingSeasons;

    @Column(name = "medicinal_uses")
    private String medicinalUses;

    @Column(name = "edible")
    private String edible;

}
