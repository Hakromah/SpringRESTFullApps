package com.telusko.controller;

import com.telusko.entity.Book;
import com.telusko.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class BookController {

    private final IBookService service;

    @Autowired
    public BookController(IBookService service) {
        this.service = service;
    }

    @PostMapping(("/register"))
    ResponseEntity<String> addBookInfo(Book book) {

        String status = service.registerBook(book);
        return new ResponseEntity<String>(status, HttpStatus.CREATED);
    }

    @GetMapping("/getallbooks")
    ResponseEntity<?> getAllBooks() {
        List<Book> status = service.fetAllBooks();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getbook/{id}")
    ResponseEntity<?> getBookInfoById(@PathVariable("id") Integer id) {
        Book book = service.fetchBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/updatebook")
    ResponseEntity<?> updateBookData(Book book) {
        String status = service.updateBookData(book);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    @PostMapping("/updatebook/{id}/{price}")
    ResponseEntity<?> updateBookDataById(@PathVariable("id") Integer id, @PathVariable("price") Double price) {
        String status = service.updateBookDataById(id, price);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    @PostMapping("/deletebook/{id}")
    ResponseEntity<?> deleteBookInfo(@PathVariable("id") Integer id) {
        String status = service.deleteBook(id);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

}
