package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Book;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public BookService() {
    }

    public void createBook(Book book) throws AlreadyExistsException {
        bookDAO.save(book);
    }

    public List<Book> getBooks() {
        return bookDAO.getList();
    }

    public Book getBook(Long id) throws NotFoundException {
        return bookDAO.find(id);
    }

    public void updateBook(Book book) throws NotFoundException {
        bookDAO.update(book);
    }

    public void deleteBook(Long id) throws NotFoundException {
        bookDAO.delete(id);
    }

}
