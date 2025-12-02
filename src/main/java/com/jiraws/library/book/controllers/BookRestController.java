package com.jiraws.library.book.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jiraws.library.book.dto.BookDTO;
import com.jiraws.library.book.model.BookEntity;
import com.jiraws.library.book.model.exception.BookCreationException;
import com.jiraws.library.book.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String get() {
        return "books";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO.PostOutput post(@Valid @RequestBody BookDTO.PostInput input) throws BookCreationException {
        BookEntity newBook = this.bookService.createBook(input.getBookName(), input.getBookPages());
        return BookDTO.PostOutput.builder()
        .id(newBook.getId())
        .bookName(newBook.getName())
        .bookPages(newBook.getPages())
        .build();
    }
}
