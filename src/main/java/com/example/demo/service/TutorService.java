package com.example.demo.service;

import com.example.demo.modal.Tutor;
import com.example.demo.modal.Classes;
import com.example.demo.repository.TutorRepositoryFake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TutorService {

    @Autowired
    private TutorRepositoryFake tutorRepo;

    // Trả về list lớp theo yêu cầu frontend
    public List<Map<String, String>> getListClass(Long userId) {
        Tutor tutor = tutorRepo.getTutorByUserId(userId);
        List<Map<String, String>> res = new ArrayList<>();

        if (tutor != null && tutor.getClasses() != null) {
            for (Classes c : tutor.getClasses()) {
                Map<String, String> cls = new HashMap<>();
                cls.put("courseName", c.getCourseName());
                cls.put("courseCode", c.getCourseCode());
                cls.put("classId", c.getCourseCode().replaceAll("[()]", "")); // VD: CO3001
                cls.put("tutorName", c.getTutorName());
                cls.put("tutorMSCB", c.getTutorMSCB());
                res.add(cls);
            }
        }

        return res;
    }
}
