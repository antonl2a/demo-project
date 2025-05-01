package com.demo_project.DemoProject.web.service;

import com.demo_project.DemoProject.domain.dto.UserDto;

public interface AuthenticationService {

    void registerUser(UserDto userDto);

    void loginUser(UserDto user);
}
