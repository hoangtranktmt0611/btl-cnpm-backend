package com.example.demo.repository;

import com.example.demo.modal.User;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class UserRepositoryFake {

    private List<User> users = new ArrayList<>();

    public UserRepositoryFake() {
        users.add(new User(1L, "admin", "admin123", "ADMIN", false));
        users.add(new User(2L, "hoang", "123456", "STUDENT", false));
        users.add(new User(3L, "tutor1", "tutorpass", "TUTOR", false));
        users.add(new User(4L, "tutor2", "tutorpass2", "TUTOR", false));

    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
