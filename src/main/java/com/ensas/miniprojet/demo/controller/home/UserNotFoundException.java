package com.ensas.miniprojet.demo.controller.home;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
