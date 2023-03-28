package com.example.spring_angular.Service;

import com.example.spring_angular.Model.Student;
import com.example.spring_angular.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(Student student){
        student.setMatricule(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(Long id){
        return studentRepository.findById(id);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
