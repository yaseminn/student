package com.example.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentRepositoryByEmail =
                studentRepository.findByEmail(student.getEmail());
        if(studentRepositoryByEmail.isPresent()) {
            throw new IllegalStateException("Student already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean existsById = studentRepository.existsById(studentId);
        if(existsById) {
            studentRepository.deleteById(studentId);
        }else{
            throw new IllegalStateException("Student does not exist");
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student does not exist"));

        if(name != null && !name.isEmpty() &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if(email != null && !email.isEmpty() &&
                !Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentRepositoryByEmail = studentRepository.findByEmail(email);
            if(studentRepositoryByEmail.isPresent()) {
                throw new IllegalStateException("Student already exists");
            }
            student.setEmail(email);
        }
    }
}

