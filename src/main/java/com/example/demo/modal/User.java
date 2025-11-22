package com.example.demo.modal;

public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
    private boolean ssoUser;

    public User(Long id, String username, String password, String role, boolean ssoUser) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.ssoUser = ssoUser;
    }
    public User(Long id, String username, String password, String role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
}

    public User() {}

    // getters + setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public boolean isSsoUser() { return ssoUser; }
    public void setSsoUser(boolean ssoUser) { this.ssoUser = ssoUser; }
}
