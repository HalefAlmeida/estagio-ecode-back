package com.api.estagioecode.controller;

import com.api.estagioecode.model.dto.StateDTO;
import com.api.estagioecode.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/states")
public class StateController implements ControllerInterface<StateDTO> {

    @Autowired
    private StateService service;

    @Override
    public ResponseEntity<StateDTO> save(StateDTO stateDTO) {
        return ResponseEntity.ok(service.save(stateDTO));
    }

    @Override
    public ResponseEntity<StateDTO> update(StateDTO stateDTO) {
        return ResponseEntity.ok(service.update(stateDTO));
    }

    @Override
    public ResponseEntity<List<StateDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<StateDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<StateDTO> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
