package com.demo_project.DemoProject.web.controller;

import com.demo_project.DemoProject.domain.dto.UserDto;
import com.demo_project.DemoProject.exception.DemoAppException;
import com.demo_project.DemoProject.web.controller.service.impl.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(UserDto user) {
        try {
            authenticationService.registerUser(user);
        } catch(DemoAppException demoAppException) {
            return new ResponseEntity<>("User validation failed", HttpStatusCode.valueOf(403));
        }

        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @ExceptionHandler(DemoAppException.class)
    public void demoAppException(DemoAppException e) {
        LOGGER.error("Demo App exception.", e);
    }
}
