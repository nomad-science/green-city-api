package io.greencity.greencityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.greencity.greencityapi.models.dto.PlantDto;

import java.util.List;

public interface PlantRepository extends JpaRepository<PlantDto, Long> {

    public List<PlantDto> findAll();

    public PlantDto findByScientificName(String scientificName);

}
