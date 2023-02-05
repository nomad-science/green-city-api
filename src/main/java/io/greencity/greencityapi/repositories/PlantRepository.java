package io.greencity.greencityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.greencity.greencityapi.models.dto.PlantDto;

public interface PlantRepository extends JpaRepository<PlantDto, Long> {

    public PlantDto findByScientificName(String scientificName);

}
