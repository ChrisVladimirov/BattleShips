package com.example.battleships.models.DTOs;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterDTO {

    @NotBlank
    @Size(min = 3, max = 10)
    private String username;
    @NotBlank
    @Size(min = 5, max = 20)
    private String fullName;

    @Email(regexp = "(\\w+)@(\\w+).(\\w+)")
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 3)
    private String password;

    @NotBlank
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
