package io.greencity.greencityapi.unit.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.greencity.greencityapi.mapping.interfaces.PlantMapper;
import io.greencity.greencityapi.models.beans.Plant;
import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.repositories.PlantRepository;
import io.greencity.greencityapi.services.PlantService;

import static org.mockito.BDDMockito.given;

@SpringBootTest
class GreenCityPlantMappingTest {

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
