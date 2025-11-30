package com.example.demo.service;

import com.example.demo.modal.User;
import com.example.demo.repository.UserRepositoryFake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepositoryFake repo;

    public User login(String username, String password) {
        User u = repo.findByUsername(username);
        if (u == null) return null;
        if (!u.getPassword().equals(password)) return null;
        return u;
    }
}
