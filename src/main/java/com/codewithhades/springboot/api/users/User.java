package com.codewithhades.springboot.api.users;

import java.util.UUID;

public class User {

    private final String id;
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}