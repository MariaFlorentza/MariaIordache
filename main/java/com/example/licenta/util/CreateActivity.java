package com.example.licenta.util;

import java.util.ArrayList;
import java.util.List;

public class CreateActivity {
    private static CreateActivity instance;

    private List<User> users = new ArrayList<>();
    private CreateActivity() {}

    public static CreateActivity getInstance() {
        if(instance == null) {
            instance = new CreateActivity();
        }
        return instance;
    }
    public boolean register(String name, String last_name, String email, String phone, String username, String password) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return false;
            }
            if (user.getEmail().equals(email)){
                return false;
            }
        }
        User newUser = new User(name, last_name, email, phone, username, password);
        users.add(newUser);
        return true;
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
