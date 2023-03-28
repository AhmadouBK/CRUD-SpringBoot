package com.example.spring_angular.Controller;

import com.example.spring_angular.Model.Student;
import com.example.spring_angular.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    public final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAllStudent();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student)
    {
        Student currentStudent = studentService.findStudentById(id)
                .orElseThrow(RuntimeException::new);
        currentStudent.setName(student.getName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setClasse(student.getClasse());
        currentStudent.setPhone(student.getPhone());
        return studentService.addStudent(currentStudent);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
