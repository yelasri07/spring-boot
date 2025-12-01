package com.jiraws.library.book.services;

import org.springframework.stereotype.Service;

import com.jiraws.library.book.model.BookEntity;
import com.jiraws.library.book.persistence.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public String createBook(String bookName, Integer bookPages) {

        BookEntity newBook = BookEntity.builder().name(bookName).pages(bookPages).build();

        BookEntity existingBook = bookRepository.findByNameAndPages(bookName, bookPages);
        if (existingBook != null) {
            return "Book already exist";
        }

        this.bookRepository.save(newBook);

        return "hello book";

    } 

}
