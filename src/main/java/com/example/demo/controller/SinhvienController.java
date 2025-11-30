package com.example.demo.controller;

import com.example.demo.modal.Tutor;
import com.example.demo.service.SinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/sinhvien")
@CrossOrigin(origins = "http://localhost:3000")
public class SinhvienController {

    @Autowired
    private SinhvienService sinhvienService;

    @GetMapping("/getlistclass")
    public List<Map<String, String>> getListClass(@RequestParam Long userId) {
        return sinhvienService.getListClass(userId);
    }
    @PostMapping("/submit-registration")
    public Map<String, Object> submitRegistration(@RequestBody Map<String, Object> payload) {
        Long userId = Long.valueOf(payload.get("userId").toString());
        return sinhvienService.submitRegistrationForm(userId, payload);
    }

    @GetMapping("/get-tutor-list")
    public Map<String, Object> getTutorList(@RequestParam Long userId) {
        List<Tutor> tutors = sinhvienService.getListTutorIfRegistered(userId);
        
        Map<String, Object> response = new HashMap<>();
        if (tutors.isEmpty()) {
            response.put("success", false);
            response.put("message", "Bạn chưa đăng ký chương trình hoặc không có Tutor nào.");
            response.put("data", tutors);
        } else {
            response.put("success", true);
            response.put("data", tutors);
        }
        return response;
    }
}
