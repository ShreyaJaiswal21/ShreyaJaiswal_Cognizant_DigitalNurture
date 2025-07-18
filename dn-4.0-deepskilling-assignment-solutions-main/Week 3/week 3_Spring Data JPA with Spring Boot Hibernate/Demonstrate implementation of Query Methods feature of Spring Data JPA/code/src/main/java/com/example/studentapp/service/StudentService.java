package com.example.studentapp.service;

import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> searchByName(String keyword) {
        return repository.findByNameContaining(keyword);
    }

    public List<Student> filterByDepartmentPrefix(String prefix) {
        return repository.findByDepartmentStartingWith(prefix);
    }

    public List<Student> getHighScorers(double threshold) {
        return repository.findByMarksGreaterThan(threshold);
    }

    public List<Student> getLowScorers(double maxMarks) {
        return repository.findByMarksLessThan(maxMarks);
    }

    public List<Student> getEnrolledBetween(LocalDate start, LocalDate end) {
        return repository.findByEnrollmentDateBetween(start, end);
    }

    public List<Student> getTop3Students() {
        return repository.findTop3ByOrderByMarksDesc();
    }

    public List<Student> getSortedByDate(String department) {
        return repository.findByDepartment(department, Sort.by(Sort.Direction.DESC, "enrollmentDate"));
    }
}
