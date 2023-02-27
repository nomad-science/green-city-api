package io.greencity.greencityapi.mapping.interfaces;

import org.mapstruct.Mapper;

import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;

import java.util.List;
import java.util.stream.Stream;

@Mapper
public interface PlantMapper {

    Plant plantDtoToPlant(PlantDto plantDto);

    List<Plant> plantDtoListToPlants(Stream<PlantDto> plantDtos);

}
