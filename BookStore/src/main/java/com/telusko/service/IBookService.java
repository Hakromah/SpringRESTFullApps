package com.telusko.service;

import com.telusko.entity.Book;

import java.util.List;

public interface IBookService {

    String registerBook(Book book);

    Book fetchBookById(Integer id);

    List<Book> fetAllBooks();

    String updateBookData(Book book);

    String updateBookDataById(Integer id, Double price);

    String deleteBook(Integer id);

}
