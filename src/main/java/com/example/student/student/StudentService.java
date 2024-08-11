package com.example.student.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getAllStudents(){
        return List.of(new Student(1L,
                "YASEMİN",
                39,
                LocalDate.of(1985, Month.APRIL,14),
                "yasemin@th.com"));
    }
}

