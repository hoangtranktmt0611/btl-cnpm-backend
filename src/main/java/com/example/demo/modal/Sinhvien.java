package com.example.demo.modal;

import java.util.List;

public class Sinhvien {
    private Long id;         // ID trong database
    private String mssv;     // Mã số sinh viên hiển thị frontend
    private String hoTen;
    private String email;
    private int progress;    // tiến độ 0-100
    private List<Classes> classes;
    private boolean isRegistered = false;

    public Sinhvien() {}

    public Sinhvien(Long id, String mssv, String hoTen, String email, int progress, List<Classes> classes) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.email = email;
        this.progress = progress;
        this.classes = classes;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMssv() { return mssv; }
    public void setMssv(String mssv) { this.mssv = mssv; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }

    public List<Classes> getClasses() { return classes; }
    public void setClasses(List<Classes> classes) { this.classes = classes; }

    public boolean isRegistered() { return isRegistered; }
    public void setRegistered(boolean registered) { isRegistered = registered; }
}
