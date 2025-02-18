package com.demo_project.DemoProject.web.controller.service.impl;

import com.demo_project.DemoProject.domain.dto.UserDto;

public interface AuthenticationService {

    void registerUser(UserDto userDto);
}
