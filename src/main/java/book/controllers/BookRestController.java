package book.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import book.services.BookService;

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

}
