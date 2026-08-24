package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return service.getBookById(bookId);
    }
    
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable int bookId,@Valid @RequestBody Book book) {
        return service.updateBook(bookId, book);
    }

    @PatchMapping("/{bookId}/availability")
    public Book updateAvailability(@PathVariable int bookId,@RequestBody Book book) {
        return service.updateAvailability(bookId, book.isAvailable());
    }

    @DeleteMapping("/{bookId}")
    public String deleteBook( @PathVariable int bookId) {
        return service.deleteBook(bookId);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor( @PathVariable String author) {
        return service.getBooksByAuthor(author);
    }

    @GetMapping("/name/{bookName}")
    public List<Book> getBooksByName(@PathVariable String bookName) {
        return service.getBooksByName(bookName);
    }
   
    @GetMapping("/available")
    public List<Book> getAvailableBooks() {
        return service.getAvailableBooks();
    }
   
    
    @GetMapping("/price/{price}")
    public List<Book> getBooksBelowPrice(@PathVariable double price) {
        return service.getBooksBelowPrice(price);
    }
}
