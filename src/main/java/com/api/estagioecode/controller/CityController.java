package com.api.estagioecode.controller;

import com.api.estagioecode.model.dto.CityDTO;
import com.api.estagioecode.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController implements ControllerInterface<CityDTO> {

    @Autowired
    private CityService service;

    @Override
    public ResponseEntity<CityDTO> save(CityDTO cityDTO) {
        return ResponseEntity.ok(service.save(cityDTO));
    }

    @Override
    public ResponseEntity<CityDTO> update(CityDTO cityDTO) {
        return ResponseEntity.ok(service.update(cityDTO));
    }

    @Override
    public ResponseEntity<List<CityDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<CityDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<CityDTO> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
