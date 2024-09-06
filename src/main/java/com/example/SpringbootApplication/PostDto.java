package com.example.SpringbootApplication;

public class PostDto {

    private String name;
    private String email;

    // Constructors, getters, and setters
    public PostDto() {}

    public PostDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
