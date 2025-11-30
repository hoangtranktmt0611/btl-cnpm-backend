package com.example.demo.modal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lich {
    private Long id;
    private String title;
    private LocalDateTime ngayGioBatDau;
    private LocalDateTime ngayGioKetThuc;
    private String status; // "Đã hoàn thành", "Sắp tới"

    public Lich() {}

    public Lich(Long id, String title, LocalDateTime ngayGioBatDau, LocalDateTime ngayGioKetThuc, String status) {
        this.id = id;
        this.title = title;
        this.ngayGioBatDau = ngayGioBatDau;
        this.ngayGioKetThuc = ngayGioKetThuc;
        this.status = status;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getFormattedNgayGioBatDau() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    return ngayGioBatDau.format(formatter);
    }

    public String getFormattedNgayGioKetThuc() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return ngayGioKetThuc.format(formatter);
    }


    public LocalDateTime getNgayGioBatDau() { return ngayGioBatDau; }
    public void setNgayGioBatDau(LocalDateTime ngayGioBatDau) { this.ngayGioBatDau = ngayGioBatDau; }

    public LocalDateTime getNgayGioKetThuc() { return ngayGioKetThuc; }
    public void setNgayGioKetThuc(LocalDateTime ngayGioKetThuc) { this.ngayGioKetThuc = ngayGioKetThuc; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
