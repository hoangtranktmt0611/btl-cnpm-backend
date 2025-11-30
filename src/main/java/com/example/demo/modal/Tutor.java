package com.example.demo.modal;

import java.util.List;

public class Tutor extends User {
    private String name;      // họ tên
    private String email;
    private String mscb;      // mã số cán bộ
    private List<Classes> classes; // danh sách lớp

    public Tutor() {}

    // constructor kế thừa User
    public Tutor(Long id, String username, String password, String role,
                 boolean ssoUser, String name, String email, String mscb, List<Classes> classes) {
        super(id, username, password, role, ssoUser);
        this.name = name;
        this.email = email;
        this.mscb = mscb;
        this.classes = classes;
    }

    // getters + setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMscb() { return mscb; }
    public void setMscb(String mscb) { this.mscb = mscb; }

    public List<Classes> getClasses() { return classes; }
    public void setClasses(List<Classes> classes) { this.classes = classes; }
}
