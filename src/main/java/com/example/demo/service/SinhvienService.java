package com.example.demo.service;

import com.example.demo.modal.Classes;
import com.example.demo.modal.Sinhvien;
import com.example.demo.modal.Tutor;
import com.example.demo.repository.SinhvienRepositoryFake;
import com.example.demo.repository.TutorRepositoryFake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SinhvienService {

    @Autowired
    private SinhvienRepositoryFake repo;
    @Autowired
    private TutorRepositoryFake tutorRepo;

    public List<Map<String, String>> getListClass(Long userId) {
        Sinhvien sv = repo.getSinhvienByUserId(userId);
        List<Map<String, String>> res = new ArrayList<>();

        if (sv != null && sv.getClasses() != null) {
            for (Classes c : sv.getClasses()) {
                Map<String, String> cls = new HashMap<>();
                cls.put("courseName", c.getCourseName());
                cls.put("courseCode", c.getCourseCode());
                cls.put("classId", String.valueOf(c.getId())); // VD: (CO3001) → CO3001
                res.add(cls);
            }
        }

        return res;
    }
    public Map<String, Object> submitRegistrationForm(Long userId, Map<String, Object> formData) {
        Sinhvien sv = repo.getSinhvienByUserId(userId);
        Map<String, Object> response = new HashMap<>();

        if (sv == null) {
            response.put("success", false);
            response.put("message", "User not found");
            return response;
        }

        repo.save(sv);

        response.put("success", true);
        response.put("message", "Đã cập nhật thông tin đăng ký thành công!");
        return response;
    }
    public List<Tutor> getListTutorIfRegistered(Long userId) {
        Sinhvien sv = repo.getSinhvienByUserId(userId);

        if (sv != null && sv.isRegistered()) {
            return tutorRepo.getAllTutors();
        }

        return new ArrayList<>(); 
    }
}
