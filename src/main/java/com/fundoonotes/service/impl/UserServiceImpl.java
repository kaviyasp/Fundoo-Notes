package com.fundoonotes.service.impl;

import com.fundoonotes.dto.request.UserRegisterRequestDto;
import com.fundoonotes.dto.response.UserResponseDto;
import com.fundoonotes.entity.User;
import com.fundoonotes.exception.UserAlreadyExistsException;
import com.fundoonotes.repository.UserRepository;
import com.fundoonotes.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto register(UserRegisterRequestDto requestDto) {

        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already registered");
        }

        User user = new User();
        user.setFirstName(requestDto.getFirstName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getEmail()
        );
    }
}