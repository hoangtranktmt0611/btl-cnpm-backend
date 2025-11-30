package com.example.demo.service;

import com.example.demo.modal.*;
import com.example.demo.repository.ClassRepositoryFake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ClassService {

    private final ClassRepositoryFake classRepo;

    @Autowired
    public ClassService(ClassRepositoryFake classRepo) {
        this.classRepo = classRepo;
    }

    // --- Lấy thông tin lớp ---
    public Map<String, Object> getClassInfo(Long classId) {
        Classes c = classRepo.getClassById(classId);
        Map<String, Object> info = new HashMap<>();

        if (c != null) {
            info.put("courseName", c.getCourseName());
            info.put("courseCode", c.getCourseCode());
            info.put("description", "Let's learn about colors, color contrast and color styles...");
            info.put("maLop", c.getId()); // hoặc c.getCourseCode() nếu muốn
            info.put("soSinhVien", c.getStudents() != null ? c.getStudents().size() : 0);
            info.put("soBaiGiang", c.getLectures() != null ? c.getLectures().size() : 0);
        }

        return info;
    }

    // --- Lấy danh sách bài giảng ---
    public List<Map<String, Object>> getListLecture(Long classId) {
        Classes c = classRepo.getClassById(classId);
        List<Map<String, Object>> res = new ArrayList<>();

        if (c != null && c.getLectures() != null) {
            for (Lecture l : c.getLectures()) {
                Map<String, Object> lec = new HashMap<>();
                lec.put("title", l.getTitle());
                lec.put("desc", l.getDescription());
                lec.put("type", l.getType());      // "file", "video", "link"
                lec.put("icon", l.getType());      // frontend sẽ map type → icon
                res.add(lec);
            }
        }

        return res;
    }

    // --- Lấy danh sách quiz ---
    public List<Map<String, Object>> getListQuiz(Long classId) {
        Classes c = classRepo.getClassById(classId);
        List<Map<String, Object>> res = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        if (c != null && c.getQuizzes() != null) {
            for (Quiz q : c.getQuizzes()) {
                Map<String, Object> quiz = new HashMap<>();
                quiz.put("name", q.getName());
                quiz.put("status", q.getStatus());
                quiz.put("date", q.getDeadline() != null ? "Hạn: " + q.getDeadline().format(fmt) : "");
                quiz.put("duration", q.getDuration() != 0 ? q.getDuration() + " phút" : "");
                quiz.put("submitted", q.getSubmitted() + "/" + q.getTotal() + " đã nộp");
                quiz.put("isAvailable", q.isAvailable());
                res.add(quiz);
            }
        }

        return res;
    }

    // --- Lấy danh sách sinh viên ---
    public List<Map<String, Object>> getListSinhvien(Long classId) {
        Classes c = classRepo.getClassById(classId);
        List<Map<String, Object>> res = new ArrayList<>();

        if (c != null && c.getStudents() != null) {
            for (Sinhvien s : c.getStudents()) {
                Map<String, Object> sv = new HashMap<>();
                sv.put("id", s.getMssv());
                sv.put("name", s.getHoTen());
                sv.put("email", s.getEmail());
                sv.put("progress", s.getProgress());
                res.add(sv);
            }
        }

        return res;
    }

    // --- Lấy danh sách lịch ---
    public List<Map<String, Object>> getListLich(Long classId) {
        Classes c = classRepo.getClassById(classId);
        List<Map<String, Object>> res = new ArrayList<>();

        if (c != null && c.getSchedule() != null) {
            for (Lich l : c.getSchedule()) {
                Map<String, Object> schedule = new HashMap<>();
                schedule.put("title", l.getTitle());
                schedule.put("date", l.getNgayGioBatDau() != null ? l.getNgayGioBatDau().toString().substring(0, 10) : "");
                schedule.put("time", l.getNgayGioBatDau() != null && l.getNgayGioKetThuc() != null ?
                        l.getNgayGioBatDau().toString().substring(11, 16) + " - " +
                        l.getNgayGioKetThuc().toString().substring(11, 16) : "");
                schedule.put("status", l.getStatus());
                res.add(schedule);
            }
        }

        return res;
    }
}
