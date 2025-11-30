package com.example.demo.repository;

import com.example.demo.modal.Classes;
import com.example.demo.modal.Tutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TutorRepositoryFake {

    private List<Tutor> tutors = new ArrayList<>();

    public TutorRepositoryFake() {
        
        // Tutor 1: Yatzilín
        List<Classes> classesTutor1 = new ArrayList<>();
        classesTutor1.add(new Classes(1L, "Công nghệ Phần mềm", "(CO3001)", "Yatzilín", "2011234", null, null));
        classesTutor1.add(new Classes(2L, "Lập trình hướng đối tượng", "(CO2002)", "Yatzilín", "2011234", null, null));

        tutors.add(new Tutor(
            3L, "tutor1", "tutorpass", "TUTOR", false,
            "Yatzilín", "tutor1@hcmut.edu.vn", "2011234", classesTutor1
        ));

        // Tutor 2: Nguyễn Văn B
        List<Classes> classesTutor2 = new ArrayList<>();
        classesTutor2.add(new Classes(4L, "Mạng Máy Tính", "(CO3011)", "Nguyễn Văn B", "2015678", null, null));

        tutors.add(new Tutor(
            4L, "tutor2", "tutorpass2", "TUTOR", false,
            "Nguyễn Văn B", "tutor2@hcmut.edu.vn", "2015678", classesTutor2
        ));
        
       
    }

    public Tutor getTutorByUserId(Long userId) {
        return tutors.stream()
                .filter(t -> t.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public List<Tutor> getAllTutors() {
        return tutors;
    }

    public void save(Tutor tutor) {
        for (int i = 0; i < tutors.size(); i++) {
            if (tutors.get(i).getId().equals(tutor.getId())) {
                tutors.set(i, tutor);
                return;
            }
        }
        tutors.add(tutor);
    }
}