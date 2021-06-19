package com.api.estagioecode.controller;

import com.api.estagioecode.model.dto.ClientDTO;
import com.api.estagioecode.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController implements ControllerInterface<ClientDTO> {

    @Autowired
    private ClientService service;

    @Override
    public ResponseEntity<ClientDTO> save(ClientDTO clientDTO) {
        return ResponseEntity.ok(service.save(clientDTO));
    }

    @Override
    public ResponseEntity<ClientDTO> update(ClientDTO clientDTO) {
        return ResponseEntity.ok(service.update(clientDTO));
    }

    @Override
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<ClientDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<ClientDTO> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
