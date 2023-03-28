package com.example.spring_angular.Repository;

import com.example.spring_angular.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
