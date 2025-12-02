package com.jiraws.library.book.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiraws.library.book.dto.BookDTO;
import com.jiraws.library.book.model.exception.BookCreationException;
import com.jiraws.library.book.services.BookService;

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
    public String post(@RequestBody BookDTO.PostInput input) throws BookCreationException {
        return this.bookService.createBook(input.getBookName(), input.getBookPages());
    }
}
