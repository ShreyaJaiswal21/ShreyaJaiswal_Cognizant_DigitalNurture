package com.example.studentapp.controller;

import com.example.studentapp.entity.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String keyword) {
        return service.searchByName(keyword);
    }

    @GetMapping("/department")
    public List<Student> filterByDepartment(@RequestParam String prefix) {
        return service.filterByDepartmentPrefix(prefix);
    }

    @GetMapping("/top3")
    public List<Student> top3Students() {
        return service.getTop3Students();
    }

    @GetMapping("/between")
    public List<Student> betweenDates(@RequestParam String from, @RequestParam String to) {
        return service.getEnrolledBetween(LocalDate.parse(from), LocalDate.parse(to));
    }

    @GetMapping("/greater")
    public List<Student> greaterThan(@RequestParam double marks) {
        return service.getHighScorers(marks);
    }

    @GetMapping("/less")
    public List<Student> lessThan(@RequestParam double marks) {
        return service.getLowScorers(marks);
    }

    @GetMapping("/sorted")
    public List<Student> sortedByEnrollment(@RequestParam String department) {
        return service.getSortedByDate(department);
    }
}
