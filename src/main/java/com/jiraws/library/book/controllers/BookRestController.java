package com.jiraws.library.book.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiraws.library.book.services.BookService;

@RestController
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String get(@RequestParam String bookName, @RequestParam Integer bookPages) {

        return this.bookService.createBook(bookName, bookPages);

    }

    @PostMapping("/book")
    public String post() {
        return "hello post";
    }
}
