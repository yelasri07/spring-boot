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
    
    public String createBook(String bookName, Integer bookPages) throws BookCreationException {

        if (bookName == null || bookName.isBlank()) {
            throw new BookCreationException("Error book name");
        }

        if (bookPages ==  null || bookPages < 10) {
            throw new BookCreationException("Error book pages");
        }

        BookEntity newBook = BookEntity.builder().name(bookName).pages(bookPages).build();

        BookEntity existingBook = bookRepository.findByNameAndPages(bookName, bookPages);
        if (existingBook != null) {
            throw new BookCreationException("Book already exist");
        }

        this.bookRepository.save(newBook);

        return "book saved";

    } 

}
