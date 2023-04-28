package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public abstract class BaseEntity {

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
}
