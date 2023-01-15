package io.greencity.greencityapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.greencity.greencityapi.models.dto.PlantDto;

@Repository
public interface PlantRepository extends JpaRepository<PlantDto, Long> {

    public PlantDto findByScientificName(String scientificName);

}
