package io.greencity.greencityapi.unit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.repositories.PlantRepository;
import io.greencity.greencityapi.services.PlantService;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class PlantServiceTest {

    @MockBean
    PlantRepository fakeRepo;

    @Autowired
    PlantService service;

    @Test
    void plantServiceConvertsDataCorrectly() {
        PlantDto testPlant = new PlantDto();
        testPlant.setScientificName("test-name");
        List<PlantDto> tests = new ArrayList<>();
        tests.add(testPlant);
        given(fakeRepo.findAll()).willReturn(tests);
        assertEquals("test-name", service.getPlants().get(0).getScientificName());
    }

}
