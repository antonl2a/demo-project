package com.demo_project.DemoProject.web.controller.service.impl;

import com.demo_project.DemoProject.domain.dto.UserDto;
import com.demo_project.DemoProject.domain.entities.User;
import com.demo_project.DemoProject.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl  implements AuthenticationService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    //TODO create LOGGER singleton

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void registerUser(UserDto userDto) {
        User user = mapUser(userDto);
        validateUser(user); //TODO think about how to process this validation
        userRepository.save(user);
    }

    private void validateUser(User user) {
        Optional<User> userToValidate = userRepository.findByName(user.getName());
        if (userToValidate.isPresent()) {
            throw new RuntimeException("A User with name" + user.getName() + "already exists");
        }
    }

    private User mapUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
