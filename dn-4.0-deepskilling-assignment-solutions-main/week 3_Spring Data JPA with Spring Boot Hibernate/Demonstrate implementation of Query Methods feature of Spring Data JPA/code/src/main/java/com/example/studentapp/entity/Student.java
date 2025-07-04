package com.example.studentapp.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private double marks;
    private LocalDate enrollmentDate;

    // Getters and Setters
}
