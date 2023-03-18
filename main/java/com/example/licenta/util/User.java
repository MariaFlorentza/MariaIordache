package com.example.licenta.util;

import androidx.annotation.NonNull;

public class User {
    private String name;
    private String last_name;
    private String email;
    private String phone;
    private String username;
    private String password;



    public User(String name, String last_name, String email, String phone, String username, String password) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
