package com.jiraws.library.book.services;

import org.springframework.stereotype.Service;

import com.jiraws.library.book.model.BookEntity;
import com.jiraws.library.book.model.exception.BookCreationException;
import com.jiraws.library.book.persistence.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public BookEntity createBook(String bookName, Integer bookPages) throws BookCreationException {
        if (bookPages < 10) {
            throw new BookCreationException("Error book pages");
        }
        
        BookEntity existingBook = bookRepository.findByNameAndPages(bookName, bookPages);
        if (existingBook != null) {
            throw new BookCreationException("Book already exist");
        }
        
        BookEntity newBook = BookEntity.builder().name(bookName).pages(bookPages).build();
        this.bookRepository.save(newBook);

        return newBook;
    } 

}
