package com.example.demo.controller;

import com.example.demo.service.SinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
