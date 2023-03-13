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

    private static final String TEST = "test-";
    private static final String TEST_NAME = TEST + "name";

    @MockBean
    PlantRepository fakeRepo;

    @Autowired
    PlantService service;

    private List<PlantDto> setup(int numberOfObjects) {
        List<PlantDto> testData = new ArrayList<>();
        for (int i = 0; i < numberOfObjects; i++) {
            PlantDto newPlant = new PlantDto();
            newPlant.setScientificName(TEST + Integer.toString(i));
            testData.add(newPlant);
        }

        return testData;
    }

    @Test
    void plantServiceConvertsSampleDataCorrectly() {
        List<PlantDto> testData = setup(3);
        given(fakeRepo.findAll()).willReturn(testData);
        SearchResult<Plant> testResults = service.getPlants();
        assertEquals(3, testResults.getResults().size());
        assertEquals(TEST + "0", testResults.getResults().get(0).getScientificName());
    }

    @Test
    void plantServiceReturnsEmptySearchResultsAndCorrectStatusCodeForInvalidEntry() {
        given(fakeRepo.findByScientificName(TEST_NAME)).willReturn(null);
        SearchResult<Plant> testResult = service.getPlantByScientificName(TEST_NAME);
        assertEquals(0, testResult.getResults().size());
        assertEquals(HttpStatus.NOT_FOUND, testResult.getStatusCode());
    }

    @Test
    void plantServiceReturnsSearchResultAndOkayStatusForExistingEntry() {
        given(fakeRepo.findByScientificName(TEST_NAME)).willReturn(new PlantDto());
        SearchResult<Plant> testResult = service.getPlantByScientificName(TEST_NAME);
        assertEquals(1, testResult.getResults().size());
        assertEquals(HttpStatus.OK, testResult.getStatusCode());
    }

}
