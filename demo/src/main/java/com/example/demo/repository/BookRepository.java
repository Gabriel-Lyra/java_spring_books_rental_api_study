package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Book;

import lombok.Getter;

@Component
public class BookRepository {

        @Getter
        private List<Book> repository = Collections.synchronizedList(new ArrayList<>(
                        List.of(
                                        new Book(0L, "Book1", 176),
                                        new Book(1L, "Book2", 45),
                                        new Book(2L, "Book3", 78),
                                        new Book(3L, "Book4", 233),
                                        new Book(4L, "Book5", 582))));

}
