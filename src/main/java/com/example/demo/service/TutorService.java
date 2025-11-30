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
    // CẬP NHẬT: Trả về trực tiếp List<Classes> thay vì List<Map>
    public List<Classes> getListClass(Long userId) {
        Tutor tutor = tutorRepo.getTutorByUserId(userId);
        
        // Kiểm tra null an toàn
        if (tutor != null && tutor.getClasses() != null) {
            return tutor.getClasses(); // Trả về nguyên danh sách object
        }
        
        return new ArrayList<>(); // Trả về list rỗng nếu không có dữ liệu
    }

    // Hàm tạo lớp mới
    public Classes createNewClass(Classes newClass, Long userId) {
        Classes tutor_class= new Classes(newClass);
        Tutor tutor=tutorRepo.getTutorByUserId(userId);
        tutor.addClasses(tutor_class);
        tutorRepo.save(tutor);
        return tutor_class;
    }

    // Các hàm profile giữ nguyên
    public Tutor getTutorProfile(Long userId) {
        return tutorRepo.getTutorByUserId(userId);
    }

    public Tutor updateTutorProfile(Long userId, Tutor updatedInfo) {
        Tutor tutor = tutorRepo.getTutorByUserId(userId);
        if (tutor != null) {
            if (updatedInfo.getName() != null) tutor.setName(updatedInfo.getName());
            if (updatedInfo.getEmail() != null) tutor.setEmail(updatedInfo.getEmail());
            if (updatedInfo.getMscb() != null) tutor.setMscb(updatedInfo.getMscb());
            return tutor;
        }
        return null;
    }
}