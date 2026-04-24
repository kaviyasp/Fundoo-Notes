package com.fundoonotes.dto.response;

public class UserResponseDto {

    private Long id;
    private String firstName;
    private String email;

    public UserResponseDto(Long id, String firstName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}