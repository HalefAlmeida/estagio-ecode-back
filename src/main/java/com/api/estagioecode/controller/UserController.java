package com.api.estagioecode.controller;

import com.api.estagioecode.model.dto.UserDTO;
import com.api.estagioecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController implements ControllerInterface<UserDTO> {

    @Autowired
    private UserService service;

    @Override
    public ResponseEntity<UserDTO> save(UserDTO userDTO) {
        return ResponseEntity.ok(service.save(userDTO));
    }

    @Override
    public ResponseEntity<UserDTO> update(UserDTO userDTO) {
        return ResponseEntity.ok(service.update(userDTO));
    }

    @Override
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<UserDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<UserDTO> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> findByEmail(String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }
}
