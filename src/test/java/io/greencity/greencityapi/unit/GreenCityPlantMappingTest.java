package io.greencity.greencityapi.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import io.greencity.greencityapi.mapping.interfaces.PlantMapper;
import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;

class GreenCityPlantMappingTest {

	private PlantMapper plantMapper = Mappers.getMapper(PlantMapper.class);

	@Test
	void plantMappingShouldConvertValuesCorrectly() {
		PlantDto dto = new PlantDto();
		dto.setScientificName("test-name");
		Plant testPlant = plantMapper.plantDtoToPlant(dto);
		assertEquals(testPlant.getScientificName(), dto.getScientificName());
	}

}
