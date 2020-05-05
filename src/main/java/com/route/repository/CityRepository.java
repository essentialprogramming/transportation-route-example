package com.route.repository;

import com.route.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

    List<CityEntity> findAllByNameIn(List<String> names);
}
