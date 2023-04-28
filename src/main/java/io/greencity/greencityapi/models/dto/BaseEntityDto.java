package io.greencity.greencityapi.models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntityDto {

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
}
