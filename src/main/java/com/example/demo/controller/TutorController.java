package com.example.demo.controller;

import com.example.demo.service.TutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping("/get_list_class")
    public List<Map<String, String>> getListClass(@RequestBody Map<String, Long> req) {
        Long userId = req.get("userId");
        return tutorService.getListClass(userId);
    }
}
