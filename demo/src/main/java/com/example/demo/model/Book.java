package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {

    private Long id;
    private String bookName;
    private Integer bookPagesNumber;

    @Override
    public String toString() {
        return System.lineSeparator() +
                "{" +
                " id='" + getId() + "'" +
                ", bookName='" + getBookName() + "'" +
                ", bookPagesNumber='" + getBookPagesNumber() + "'" +
                "}";
    }

}
