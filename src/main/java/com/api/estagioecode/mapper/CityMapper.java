package com.api.estagioecode.mapper;

import com.api.estagioecode.model.City;
import com.api.estagioecode.model.State;
import com.api.estagioecode.model.dto.CityDTO;
import com.api.estagioecode.model.dto.StateDTO;
import com.api.estagioecode.repository.StateRepo;
import com.api.estagioecode.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper implements MapperInterface<City, CityDTO> {

    @Autowired
    private StateService stateService;

    @Autowired
    private StateMapper stateMapper;

    @Override
    public City toEntity(CityDTO cityDTO) {
//        State state = new State();
//        state.setId(cityDTO.getState().getId());

        StateDTO stateDTO = stateService.findById(cityDTO.getState().getId());

        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setState(stateMapper.toEntity(stateDTO));

        return city;
    }

    @Override
    public CityDTO toDTO(City city) {
//        State state = new State();
//        state.setId(city.getState().getId());

        StateDTO stateDTO = stateService.findById(city.getState().getId());

        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setState(stateMapper.toEntity(stateDTO));
        return cityDTO;
    }

    @Override
    public List<CityDTO> toDTO(List<City> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
