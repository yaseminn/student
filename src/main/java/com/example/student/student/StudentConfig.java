package com.example.student.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student yasemi̇n = new Student(
                    "YASEMİN",
                    LocalDate.of(1985, Month.APRIL, 14),
                    "yasemin@th.com");

            Student muhammed = new Student(
                    "MUHAMMED",
                    LocalDate.of(1985, Month.APRIL, 14),
                    "yasemin@th.com");

            studentRepository.saveAll(
                    List.of(yasemi̇n, muhammed));
        };
    }
}
