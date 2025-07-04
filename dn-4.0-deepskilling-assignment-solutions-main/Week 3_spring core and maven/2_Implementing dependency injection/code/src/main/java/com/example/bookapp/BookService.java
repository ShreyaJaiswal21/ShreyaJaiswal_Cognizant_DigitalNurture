package com.example.bookapp;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Setter-based Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBooks() {
        List<Book> books = bookRepository.getAllBooks();
        for (Book book : books) {
            System.out.println("Book: " + book.getTitle());
        }
    }
}
