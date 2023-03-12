package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<String> getAll() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok().body("Returned books: " + books);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> get(@RequestParam Long id) {
        try {
            Book tempBook = bookService.getBook(id);
            return ResponseEntity.ok().body("Returned book: " + tempBook);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Book book) {
        try {
            bookService.createBook(book);
            return ResponseEntity.ok().body("Created book: " + book);
        } catch (AlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Book book) {
        try {
            bookService.updateBook(book);
            return ResponseEntity.ok().body("Updated book of id " + book.getId() + " to: " + book);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> remove(@RequestParam Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok().body("Removed book of id: " + id);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
