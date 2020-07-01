package com.ensas.miniprojet.demo.entity;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Embeddable;

@Embeddable
@DynamicUpdate
public class Identification {
    private String username;
    private String password;

    public Identification() {
    }

    public Identification(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Identification{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
