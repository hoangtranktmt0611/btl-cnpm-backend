package com.example.demo.modal;

import java.util.ArrayList;
import java.util.List;

public class Classes {
    private Long id;
    private String courseName;
    private String courseCode;
    private String tutorName;
    private String tutorMSCB;

    // --- Các trường mới bổ sung ---
    private String term;        // Học kỳ (VD: HK231)
    private int maxStudent;     // Sĩ số tối đa
    private int totalStudent;   // Sĩ số hiện tại

    private List<Lecture> lectures;
    private List<Quiz> quizzes;
    private List<Lich> schedule;
    private List<Sinhvien> students;

    public Classes() {
        this.totalStudent = 0; // Mặc định khi tạo mới là 0
        this.lectures = new ArrayList<>(); // Khởi tạo list rỗng để tránh null
        this.students = new ArrayList<>();
        
    }

     public Classes (Classes new_class) {
        this.courseName = new_class.courseName;
        this.courseCode = new_class.courseCode;
        this.tutorName = new_class.tutorName;
        this.tutorMSCB = new_class.tutorMSCB;
        this.schedule = new_class.schedule;
        this.students = new_class.students;
        this.totalStudent = new_class.totalStudent;
        this.lectures = new_class.lectures;
        this.maxStudent= new_class.maxStudent;
        this.term= new_class.term;
        this.quizzes= new_class.quizzes;
    }

    public Classes(Long id, String courseName, String courseCode,
                   String tutorName, String tutorMSCB,
                   List<Lich> lichHoc, List<Sinhvien> sinhViens) {

        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.tutorName = tutorName;
        this.tutorMSCB = tutorMSCB;
        this.schedule = lichHoc;
        this.students = sinhViens;
        this.totalStudent = (sinhViens != null) ? sinhViens.size() : 0;
        this.lectures = new ArrayList<>();
    }

    public Classes(Long id, String courseName, String courseCode, String tutorName, String tutorMSCB,
                   List<Lecture> lectures, List<Quiz> quizzes, List<Lich> schedule, List<Sinhvien> students) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.tutorName = tutorName;
        this.tutorMSCB = tutorMSCB;
        this.lectures = lectures;
        this.quizzes = quizzes;
        this.schedule = schedule;
        this.students = students;
        this.totalStudent = (students != null) ? students.size() : 0;
    }

    // --- Helper Methods cho Frontend (Quan trọng) ---
    
    // Frontend gọi s.classId -> map vào id
    public Long getClassId() { return id; }
    
    // Frontend gọi s.totalLecture -> tính từ list lectures
    public int getTotalLecture() { 
        return (lectures != null) ? lectures.size() : 0; 
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getTutorName() { return tutorName; }
    public void setTutorName(String tutorName) { this.tutorName = tutorName; }

    public String getTutorMSCB() { return tutorMSCB; }
    public void setTutorMSCB(String tutorMSCB) { this.tutorMSCB = tutorMSCB; }

    // --- Getter & Setter cho các trường mới ---
    public String getTerm() { return term; }
    public void setTerm(String term) { this.term = term; }

    public int getMaxStudent() { return maxStudent; }
    public void setMaxStudent(int maxStudent) { this.maxStudent = maxStudent; }

    public int getTotalStudent() { return totalStudent; }
    public void setTotalStudent(int totalStudent) { this.totalStudent = totalStudent; }
    // ------------------------------------------

    public List<Lecture> getLectures() { return lectures; }
    public void setLectures(List<Lecture> lectures) { this.lectures = lectures; }

    public List<Quiz> getQuizzes() { return quizzes; }
    public void setQuizzes(List<Quiz> quizzes) { this.quizzes = quizzes; }

    public List<Lich> getSchedule() { return schedule; }
    public void setSchedule(List<Lich> schedule) { this.schedule = schedule; }

    public List<Sinhvien> getStudents() { return students; }
    public void setStudents(List<Sinhvien> students) { 
        this.students = students;
        if (students != null) {
            this.totalStudent = students.size(); // Tự động cập nhật sĩ số
        }
    }
}