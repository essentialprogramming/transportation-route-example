package com.route.repository;

import com.route.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

    List<CityEntity> findAllByNameIn(List<String> names);
    Optional<CityEntity> findByName(String name);
}
