package com.example.demo;

import org.springframework.stereotype.Service;

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
