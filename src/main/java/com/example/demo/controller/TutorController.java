package com.example.demo.controller;

import com.example.demo.modal.Classes; // Import Class Model
import com.example.demo.modal.Tutor;
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

    // 1. API lấy danh sách lớp học
    // CẬP NHẬT: Sửa kiểu trả về thành List<Classes>
    @PostMapping("/get_classes")
    public List<Classes> getListClass(@RequestBody Map<String, Long> req) {
        // Lấy userId an toàn
        
        Long userId = Long.valueOf(req.get("userId").toString());
        if (userId == null || userId <= 0) {
        throw new IllegalArgumentException("userId không hợp lệ");
}
        return tutorService.getListClass(userId);
        
    }

    // 2. API tạo lớp học mới
    @PostMapping("/create_class")
    public Map<String, Object> createClass(@RequestBody Map<String, Object> req) {

        Classes newClass = new Classes();
        Long userId = Long.valueOf(req.get("userId").toString());
        Tutor tutor = tutorService.getTutorProfile(userId);
        if (userId==null) return null;
        Long newClassId = (long) tutor.numClass() + 1;
        newClass.setId(newClassId);
        newClass.setTutorMSCB(tutor.getMscb());
        newClass.setCourseName((String) req.get("courseName"));
        newClass.setCourseCode((String) req.get("courseCode"));
        newClass.setTerm((String) req.get("term"));
        newClass.setMaxStudent(Integer.parseInt(req.get("maxStudent").toString()));

        Classes created = tutorService.createNewClass(newClass, userId);

        Map<String, Object> res = new HashMap<>();
        if (created != null) {
            res.put("success", true);
            res.put("message", "Tạo lớp thành công");
            res.put("data", created);
        } else {
            res.put("success", false);
            res.put("message", "Lỗi tạo lớp");
        }
        return res;
    }

    // 3. API lấy Profile
    @PostMapping("/get_profile")
    public Tutor getProfile(@RequestBody Map<String, Long> req) {
        Long userId = Long.valueOf(req.get("userId").toString());
        return tutorService.getTutorProfile(userId);
    }

    // 4. API update Profile
    @PostMapping("/update_profile")
    public Map<String, Object> updateProfile(@RequestBody Map<String, Object> req) {
        Long userId = Long.valueOf(req.get("userId").toString());

        Tutor updateInfo = new Tutor();
        if (req.containsKey("name")) updateInfo.setName((String) req.get("name"));
        if (req.containsKey("email")) updateInfo.setEmail((String) req.get("email"));
        if (req.containsKey("mscb")) updateInfo.setMscb((String) req.get("mscb"));

        Tutor updatedTutor = tutorService.updateTutorProfile(userId, updateInfo);

        Map<String, Object> res = new HashMap<>();
        if (updatedTutor != null) {
            res.put("success", true);
            res.put("data", updatedTutor);
        } else {
            res.put("success", false);
            res.put("message", "Cập nhật thất bại");
        }
        return res;
    }
}