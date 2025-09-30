package com.example.livros.model;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    EMPLOYEE("employee");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

}
