package com.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
    private BookRepository bookRepository;
	
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.searchBooks(query);
    }

}
