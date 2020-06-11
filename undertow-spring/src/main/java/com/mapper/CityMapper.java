package com.mapper;

import com.entities.CityEntity;
import com.model.City;

import java.util.stream.Collectors;

public class CityMapper {

    public static CityEntity cityToEntity(City city) {
        return CityEntity.builder()
                .name(city.getName())
                .build();
    }

    public static City entityToCity(CityEntity entity) {
        return City.builder()
                .id(entity.getId())
                .name(entity.getName())
                .neighbours(entity.getNeighbours() != null ? entity.getNeighbours().stream().map(CityEntity::getName).collect(Collectors.toList()) : null)
                .build();
    }
}
