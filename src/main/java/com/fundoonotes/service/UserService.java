package com.fundoonotes.service;

import com.fundoonotes.dto.request.UserRegisterRequestDto;
import com.fundoonotes.dto.request.LoginRequestDto;
import com.fundoonotes.dto.response.UserResponseDto;
import com.fundoonotes.dto.response.LoginResponseDto;

public interface UserService {

    UserResponseDto register(UserRegisterRequestDto requestDto);

    LoginResponseDto login(LoginRequestDto requestDto);
}