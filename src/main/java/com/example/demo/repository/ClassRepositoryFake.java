package com.example.demo.repository;

import com.example.demo.modal.Classes;
import com.example.demo.modal.Lecture;
import com.example.demo.modal.Quiz;
import com.example.demo.modal.Lich;
import com.example.demo.modal.Sinhvien;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class ClassRepositoryFake {

    private List<Classes> classes;

    public ClassRepositoryFake() {
        // --- Fake Lectures ---
        List<Lecture> lectures1 = Arrays.asList(
                new Lecture(1L, "Chương 1: Giới thiệu về Color Styles", "Tài liệu giới thiệu cơ bản...", "file"),
                new Lecture(2L, "Video bài giảng: Design Principles", "Video hướng dẫn...", "video"),
                new Lecture(3L, "Tài liệu tham khảo: UI Components", "Bộ tài liệu...", "link"),
                new Lecture(4L, "Chương 3: Layout và Spacing", "Tài liệu...", "file")
        );

        // --- Fake Quizzes ---
        List<Quiz> quizzes1 = Arrays.asList(
                new Quiz(1L, "Kiểm tra giữa kỳ - Design Fundamentals", "Đang mở", LocalDateTime.of(2025,12,15,23,59), 60, 4, 6, true),
                new Quiz(2L, "Bài tập tuần 3 - Layout Design", "Đã kết thúc", LocalDateTime.of(2025,12,8,23,59), 45, 6, 6, false)
        );

        // --- Fake Schedule ---
        List<Lich> schedule1 = Arrays.asList(
                new Lich(1L, "Giới thiệu và Design System", LocalDateTime.of(2025,11,15,14,0), LocalDateTime.of(2025,11,15,16,0), "Đã hoàn thành"),
                new Lich(2L, "Typography và Color Theory", LocalDateTime.of(2025,11,22,14,0), LocalDateTime.of(2025,11,22,16,0), "Đã hoàn thành"),
                new Lich(3L, "Layout và Components", LocalDateTime.of(2025,11,29,14,0), LocalDateTime.of(2025,11,29,16,0), "Sắp tới"),
                new Lich(4L, "Responsive Design", LocalDateTime.of(2025,12,6,14,0), LocalDateTime.of(2025,12,6,16,0), "Sắp tới")
        );

        // --- Fake Students ---
        List<Sinhvien> students1 = Arrays.asList(
                new Sinhvien(1L, "2011234", "Nguyễn Văn An", "an.nguyen@hcmut.edu.vn", 75, null),
                new Sinhvien(2L, "2011235", "Trần Thị Bình", "binh.tran@hcmut.edu.vn", 60, null),
                new Sinhvien(3L, "2011236", "Lê Hoàng Châu", "chau.le@hcmut.edu.vn", 100, null),
                new Sinhvien(4L, "2011237", "Phạm Minh Đức", "duc.pham@hcmut.edu.vn", 45, null),
                new Sinhvien(5L, "2011238", "Võ Thị Hoa", "hoa.vo@hcmut.edu.vn", 80, null),
                new Sinhvien(6L, "2011239", "Đặng Văn Khoa", "khoa.dang@hcmut.edu.vn", 100, null)
        );

        // --- Fake Classes ---
        classes = Arrays.asList(
                new Classes( 1L, "Công nghệ Phần mềm", "(CO3001)",null, null, lectures1, quizzes1, schedule1, students1),
                new Classes(2L, "Lập trình hướng đối tượng", "(CO2002)", null, null, null, null)
        );
    }

    public List<Classes> getAllClasses() {
        return classes;
    }

    public Classes getClassById(Long classId) {
        return classes.stream().filter(c -> c.getId().equals(classId)).findFirst().orElse(null);
    }
}
