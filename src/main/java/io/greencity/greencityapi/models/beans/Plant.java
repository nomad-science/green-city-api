package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Component
public class Plant extends BaseEntity {

    private String hardinessZones;
    private int soilPh;
    private String soilType;
    private String neededNutrients;
    private String neededAmountOfSun;
    private String plantingSeasons;
    private String medicinalUses;
    private String edible;

}
