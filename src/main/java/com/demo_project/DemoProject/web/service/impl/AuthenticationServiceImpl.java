package com.demo_project.DemoProject.web.service.impl;

import com.demo_project.DemoProject.domain.dto.UserDto;
import com.demo_project.DemoProject.domain.entities.User;
import com.demo_project.DemoProject.exception.ApiErrorCode;
import com.demo_project.DemoProject.exception.DemoAppException;
import com.demo_project.DemoProject.repositories.UserRepository;
import com.demo_project.DemoProject.web.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl  implements AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDto userDto) {
        User user = mapUser(userDto);
        if(validateExistingUser(user)){
            LOGGER.debug("User with name {} already exists.", user.getName()); //todo configure logger dumping
            throw new DemoAppException("Register failed", ApiErrorCode.BAD_REQUEST);
        }
        encryptUserPassword(user);
        userRepository.save(user);
    }

    @Override
    public void loginUser(UserDto userDto) {
        User user = mapUser(userDto);

        if (!validateExistingUser(user)) {
            throw new DemoAppException(String.format("User with name %s does not exist.", user.getName()), ApiErrorCode.BAD_REQUEST);
        }

        User existingUser = userRepository.findByName(user.getName()).get();

        if (!matchUserPassword(userDto.getPassword(), existingUser.getPassword())) {
            throw new DemoAppException("User passwords do not match.", ApiErrorCode.BAD_REQUEST);
        }

    }

    private boolean matchUserPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private void encryptUserPassword(User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
    }

    private boolean validateExistingUser(User user) {
        Optional<User> userToValidate = findExistingUser(user);
        if (userToValidate.isPresent()) {
            return true;
        }
        return false;
    }

    private Optional<User> findExistingUser(User user) {
        Optional<User> userToValidate = userRepository.findByName(user.getName());
        return userToValidate;
    }

    private User mapUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
