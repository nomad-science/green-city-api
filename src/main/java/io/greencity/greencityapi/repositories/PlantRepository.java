package io.greencity.greencityapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.greencity.greencityapi.models.dto.PlantDto;

@Repository
public interface PlantRepository extends CrudRepository<PlantDto, Long> {

}
