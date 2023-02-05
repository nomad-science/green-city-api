package io.greencity.greencityapi.unit.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.greencity.greencityapi.mapping.interfaces.PlantMapper;
import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;

@SpringBootTest
class PlantMappingTest {

	@Autowired
	private PlantMapper plantMapper;

	@Test
	void plantMappingShouldConvertValuesCorrectly() {
		PlantDto dto = new PlantDto();
		dto.setScientificName("test-name");
		Plant testPlant = plantMapper.plantDtoToPlant(dto);
		assertEquals(testPlant.getScientificName(), dto.getScientificName());
	}

}
