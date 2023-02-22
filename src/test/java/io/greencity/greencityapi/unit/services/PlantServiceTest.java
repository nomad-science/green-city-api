package io.greencity.greencityapi.unit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import io.greencity.greencityapi.models.dto.PlantDto;
import io.greencity.greencityapi.models.beans.SearchResult;
import io.greencity.greencityapi.models.beans.Plant;

import io.greencity.greencityapi.repositories.PlantRepository;
import io.greencity.greencityapi.services.PlantService;

import org.springframework.http.HttpStatus;

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

    @Test
    void plantServiceReturnsEmptySearchResultsAndCorrectStatusCodeForInvalidEntry() {
        given(fakeRepo.findByScientificName("test-name")).willReturn(null);
        SearchResult<Plant> testResult = service.getPlantByScientificName("test-name");
        assertEquals(0, testResult.getResults().size());
        assertEquals(HttpStatus.NOT_FOUND, testResult.getStatusCode());
    }

    @Test
    void plantServiceReturnsSearchResultAndOkayStatusForExistingEntry() {
        given(fakeRepo.findByScientificName("test-name")).willReturn(new PlantDto());
        SearchResult<Plant> testResult = service.getPlantByScientificName("test-name");
        assertEquals(1, testResult.getResults().size());
        assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }

}
