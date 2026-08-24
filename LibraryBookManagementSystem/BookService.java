package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {

        books.add(new Book(101, "Java Programming","James Gosling", 550.0, true));
        books.add(new Book(102, "Spring Boot","Craig Walls", 650.0, true));
        books.add(new Book(103, "Wings of Fire","A.P.J. Abdul Kalam", 700.0, false));
        books.add(new Book(104, "Atomic Habits","James Clear", 600.0, true));
        books.add(new Book(105, "Think and Grow Rich","Napoleon Hill", 750.0, true));
        books.add(new Book(106, "Python Basics","Eric Matthes", 500.0, false));
        books.add(new Book(107, "SQL Fundamentals","John Smith", 450.0, true));
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        throw new BookNotFoundException("Book with ID " + bookId + " not found");
    }

    public Book updateBook(int bookId, Book updatedBook) {

        Book book = getBookById(bookId);
        book.setBookName(updatedBook.getBookName());
        book.setAuthor(updatedBook.getAuthor());
        book.setPrice(updatedBook.getPrice());
        book.setAvailable(updatedBook.isAvailable());

        return book;
    }
    
    public Book updateAvailability( int bookId, boolean available) {
        Book book = getBookById(bookId);
        book.setAvailable(available);
        return book;
    }
    
    public String deleteBook(int bookId) {
    	Book book = getBookById(bookId);
        books.remove(book);
        return "Book deleted successfully";
    }
    
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {

            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }
    
    public List<Book> getBooksByName(String bookName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {

            if (book.getBookName().equalsIgnoreCase(bookName)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {

            if (book.isAvailable()) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> getBooksBelowPrice(double price) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {

            if (book.getPrice() < price) {
                result.add(book);
            }
        }

        return result;
    }
}
