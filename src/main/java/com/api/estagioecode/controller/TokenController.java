package com.api.estagioecode.controller;

import com.api.estagioecode.config.JwtTokenUtils;
import com.api.estagioecode.model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TokenController {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtils jwtTokenUtils;
//
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest){
//    authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
//
//
//    }
//
//    private void authenticate(String email, String password) throws Exception{
//        try {
//            authenti
//        }
//
//    }
}
