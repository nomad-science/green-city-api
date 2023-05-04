package io.greencity.greencityapi.models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.stereotype.Component;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "plant")
@Component
public class PlantDto extends BaseEntityDto {

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
