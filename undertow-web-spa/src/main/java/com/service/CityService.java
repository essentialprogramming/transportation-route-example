package com.service;


import com.entities.CityEntity;
import com.mapper.CityMapper;
import com.model.City;
import com.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

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
        List<CityEntity> neighbours = repository.findAllByNameIn(city.getNeighbours());
        entity.setNeighbours(neighbours);
        for (CityEntity neighbour : neighbours) {
            neighbour.getNeighbours().add(entity);
        }
        repository.save(entity);

        return CityMapper.entityToCity(entity);
    }

    @Transactional
    public List<City> getAll() {
        return repository.findAll().stream().map(CityMapper::entityToCity).collect(Collectors.toList());
    }

    @Transactional
    public City findById(int id) {
        CityEntity existingCity = repository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "City not found."));
        return CityMapper.entityToCity(existingCity);
    }

    @Transactional
    public List<City> getNeighbours(String name) {
        CityEntity existingCity = repository.findByName(name).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "City with name " + name + " not found."));
        List<CityEntity> neighbours = existingCity.getNeighbours();
        return neighbours.stream().map(CityMapper::entityToCity).collect(Collectors.toList());
    }

    @Transactional
    public City findByName(String name) {
        CityEntity existingCity = repository.findByName(name).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "City with name " + name + " not found."));
        return CityMapper.entityToCity(existingCity);
    }

}
