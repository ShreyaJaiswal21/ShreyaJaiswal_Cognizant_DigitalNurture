package com.example.studentapp.repository;

import com.example.studentapp.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String keyword);
    List<Student> findByDepartmentStartingWith(String prefix);
    List<Student> findByMarksGreaterThan(double minMarks);
    List<Student> findByMarksLessThan(double maxMarks);
    List<Student> findByEnrollmentDateBetween(LocalDate start, LocalDate end);
    List<Student> findTop3ByOrderByMarksDesc();
    List<Student> findByDepartment(String department, Sort sort);
}
