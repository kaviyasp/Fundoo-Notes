package com.fundoonotes.dto.response;

public class LoginResponseDto {

    private String token;
    private String message;

    public LoginResponseDto(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() { return token; }
    public String getMessage() { return message; }
}