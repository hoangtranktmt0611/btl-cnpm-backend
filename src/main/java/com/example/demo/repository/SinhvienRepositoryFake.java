package com.example.demo.repository;

import com.example.demo.modal.Classes;
import com.example.demo.modal.Sinhvien;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SinhvienRepositoryFake {

    private final Map<Long, Sinhvien> sinhVienDB = new HashMap<>();

    public SinhvienRepositoryFake() {

        // Fake danh sách lớp
        Classes c1 = new Classes(1L, "Công nghệ Phần mềm", "(CO3001)", 
                "Nguyễn Văn A", "MSCB001", null, null, null, null);

        Classes c2 = new Classes(2L, "Lập trình hướng đối tượng", "(CO2002)",
                "Trần Thị B", "MSCB002", null, null, null, null);

        Classes c3 = new Classes(3L, "Cấu trúc dữ liệu", "(CO2003)",
                "Lê Văn C", "MSCB003", null, null, null, null);

        List<Classes> listClass = Arrays.asList(c1, c2, c3);

        // Fake sinh viên
        Sinhvien s1 = new Sinhvien(
                2L, "2011234", "Nguyễn Văn An", "an.nguyen@hcmut.edu.vn",
                75, listClass
        );

        sinhVienDB.put(2L, s1);
    }

    public Sinhvien getSinhvienByUserId(Long userId) {
        return sinhVienDB.get(userId);
    }
    public void save(Sinhvien sv) {
        if (sv.getId() == null) {
            sv.setId(new Random().nextLong());
        }
        sinhVienDB.put(sv.getId(), sv);
    }
}
