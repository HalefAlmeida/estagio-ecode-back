package com.api.estagioecode.service;

import com.api.estagioecode.exceptions.NotFoundException;
import com.api.estagioecode.mapper.CityMapper;
import com.api.estagioecode.model.City;
import com.api.estagioecode.model.dto.CityDTO;
import com.api.estagioecode.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ServiceInterface<City, CityDTO> {

    @Autowired
    private CityRepo repo;

    @Autowired
    private CityMapper mapper;

    @Override
    public CityDTO save(CityDTO cityDTO) {

        City city = mapper.toEntity(cityDTO);
        repo.save(city);
        cityDTO.setId(city.getId());
        return mapper.toDTO(city);
    }

    @Override
    public CityDTO update(CityDTO cityDTO) {
        City city = mapper.toEntity(cityDTO);
        repo.save(city);
        return mapper.toDTO(city);
    }

    @Override
    public List<CityDTO> findAll() {
        return mapper.toDTO(repo.findAll());
    }

    @Override
    public CityDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public CityDTO delete(Long id) {
        CityDTO cityDTO = this.findById(id);
        repo.deleteById(id);
        return cityDTO;
    }
}
