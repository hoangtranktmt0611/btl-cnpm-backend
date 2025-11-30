package com.example.demo.modal;

import java.time.LocalDateTime;

public class Quiz {
    private Long id;
    private String name;
    private String status; // "Đang mở", "Đã kết thúc"
    private LocalDateTime deadline;
    private int duration; // phút
    private int submitted; // số sinh viên đã nộp
    private int total;     // tổng số sinh viên
    private boolean isAvailable;

    public Quiz() {}

    public Quiz(Long id, String name, String status, LocalDateTime deadline, int duration, int submitted, int total, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.deadline = deadline;
        this.duration = duration;
        this.submitted = submitted;
        this.total = total;
        this.isAvailable = isAvailable;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getSubmitted() { return submitted; }
    public void setSubmitted(int submitted) { this.submitted = submitted; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
