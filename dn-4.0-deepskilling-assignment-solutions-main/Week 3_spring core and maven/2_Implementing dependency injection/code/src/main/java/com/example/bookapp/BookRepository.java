package com.example.bookapp;

import java.util.List;
import java.util.Arrays;

public class BookRepository {

    public List<Book> getAllBooks() {
        return Arrays.asList(
                new Book("Effective Java"),
                new Book("Clean Code"),
                new Book("Spring in Action")
        );
    }
}
