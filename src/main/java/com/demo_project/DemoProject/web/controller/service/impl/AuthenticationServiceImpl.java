package com.demo_project.DemoProject.web.controller.service.impl;

import com.demo_project.DemoProject.domain.dto.UserDto;
import com.demo_project.DemoProject.domain.entities.User;
import com.demo_project.DemoProject.exception.ApiErrorCode;
import com.demo_project.DemoProject.exception.DemoAppException;
import com.demo_project.DemoProject.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl  implements AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void registerUser(UserDto userDto) {
        User user = mapUser(userDto);
        validateUser(user);
        //todo encrypt password
        userRepository.save(user);
    }

    private void validateUser(User user) {
        Optional<User> userToValidate = userRepository.findByName(user.getName());
        if (userToValidate.isPresent()) {
            LOGGER.debug("A User with username %s already exists.", userToValidate.get().getName());
            throw new DemoAppException(ApiErrorCode.BAD_REQUEST, "Could not validate user.");
        }
    }

    private User mapUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
