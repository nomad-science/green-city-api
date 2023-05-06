package io.greencity.greencityapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<T, ID> extends JpaRepository<T, ID> {

    public List<T> findAll();

    public Optional<T> findByScientificName(String scientificName);

}
