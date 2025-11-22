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

        // ---------------------------
        // ⭐ Fake class của tutor1
        // ---------------------------
        List<Classes> classesTutor1 = Arrays.asList(
                new Classes(1L, "Công nghệ Phần mềm", "(CO3001)", "Yatzilín", "2011234", null, null),
                new Classes(2L, "Lập trình hướng đối tượng", "(CO2002)", "Yatzilín", "2011234", null, null),
                new Classes(3L, "Cấu trúc dữ liệu", "(CO2003)", "Yatzilín", "2011234", null, null)
        );

        tutors.add(
            new Tutor(
                3L, "tutor1", "tutorpass", "TUTOR", false,  // User params
                "Yatzilín", "tutor1@hcmut.edu.vn", "2011234", classesTutor1  // Tutor params
            )
        );


        // ---------------------------
        // ⭐ Fake class của tutor2
        // ---------------------------
        List<Classes> classesTutor2 = Arrays.asList(
                new Classes(4L, "Mạng Máy Tính", "(CO3011)", "Nguyễn Văn B", "2015678", null, null),
                new Classes(5L, "Hệ Điều Hành", "(CO3005)", "Nguyễn Văn B", "2015678", null, null)
        );

        tutors.add(
            new Tutor(
                4L, "tutor2", "tutorpass2", "TUTOR", false,
                "Nguyễn Văn B", "tutor2@hcmut.edu.vn", "2015678", classesTutor2
            )
        );
    }

    public Tutor getTutorByUserId(Long userId) {
        return tutors.stream()
                .filter(t -> t.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
