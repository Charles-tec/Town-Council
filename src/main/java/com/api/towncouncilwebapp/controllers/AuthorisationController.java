package com.api.towncouncilwebapp.controllers;

import com.api.towncouncilwebapp.dtos.LoginResponseDto;
import com.api.towncouncilwebapp.dtos.LoginTo;
import com.api.towncouncilwebapp.services.AuthorisationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Repository
public class AuthorisationController {

    public final AuthorisationService authService;

    @PostMapping(path = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LoginResponseDto> authenticateUser(@RequestBody LoginTo loginTo) {
        return ResponseEntity.ok(authService.login(loginTo.getUsername(), loginTo.getPassword()));
    }

}
