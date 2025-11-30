package com.example.demo.controller;

import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/class")
@CrossOrigin(origins = "http://localhost:3000")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }
    // --- Thông tin lớp ---
    @GetMapping("/info")
    public Map<String, Object> getClassInfo(@RequestParam Long classId) {
        return classService.getClassInfo(classId);
    }

    @GetMapping("/getlistlecture")
    public List<Map<String, Object>> getListLecture(@RequestParam Long classId) {
        return classService.getListLecture(classId);
    }

    @GetMapping("/getlistquiz")
    public List<Map<String, Object>> getListQuiz(@RequestParam Long classId) {
        return classService.getListQuiz(classId);
    }

    @GetMapping("/getlistsinhvien")
    public List<Map<String, Object>> getListSinhvien(@RequestParam Long classId) {
        return classService.getListSinhvien(classId);
    }

    @GetMapping("/getlistlich")
    public List<Map<String, Object>> getListLich(@RequestParam Long classId) {
        return classService.getListLich(classId);
    }
}
