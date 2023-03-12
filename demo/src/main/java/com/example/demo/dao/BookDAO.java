package com.example.demo.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Repository
public class BookDAO {

    // PERSISTENCE MECHANISM LAYER

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getList() {
        return bookRepository.getRepository().stream().collect(Collectors.toList());
    }

    public void save(Book book) throws AlreadyExistsException {
        if (bookRepository.getRepository().contains(book)) {
            throw new AlreadyExistsException("Book with id " + book.getId() + " already exists.");
        }
        bookRepository.getRepository().add(book);
    }

    public Book find(Long id) throws NotFoundException {
        return bookRepository.getRepository().stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("book with id " + id + " not found."));
    }

    public void update(Book book) throws NotFoundException {
        int index = bookRepository.getRepository().indexOf(find(book.getId()));
        bookRepository.getRepository().set(index, book);
    }

    public void delete(Long id) throws NotFoundException {
        int index = bookRepository.getRepository().indexOf(find(id));
        bookRepository.getRepository().remove(index);
    }

}
