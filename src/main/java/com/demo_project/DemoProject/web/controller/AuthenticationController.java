package com.demo_project.DemoProject.web.controller;

import com.demo_project.DemoProject.domain.dto.UserDto;
import com.demo_project.DemoProject.web.controller.service.impl.AuthenticationService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Void> register(UserDto user) {
        authenticationService.registerUser(user);

        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }
}
