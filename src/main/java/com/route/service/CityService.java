package com.route.service;

import com.route.entities.CityEntity;
import com.route.mapper.CityMapper;
import com.route.model.City;
import com.route.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {

    private CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public City addCity(City city) {
        CityEntity entity = CityMapper.cityToEntity(city);
        repository.save(entity);

        return CityMapper.entityToCity(entity);
    }
}
