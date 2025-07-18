package com.example.bookapp;

public class Book {
    private String title;

    // Default no-arg constructor
    public Book() {
    }

    // Parametrized constructor
    public Book(String title) {
        this.title = title;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }
}
