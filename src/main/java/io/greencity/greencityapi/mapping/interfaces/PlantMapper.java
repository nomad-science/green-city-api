package io.greencity.greencityapi.mapping.interfaces;

import org.mapstruct.Mapper;

import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;

@Mapper
public interface PlantMapper extends BasicMapper<Plant, PlantDto> {

}
