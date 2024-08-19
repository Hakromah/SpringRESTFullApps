package com.telusko.service;

import com.telusko.entity.Book;
import com.telusko.exception.BookStoreException;
import com.telusko.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    private final BookStoreRepository bRepo;

    @Autowired
    public BookService(BookStoreRepository bRepo) {
        this.bRepo = bRepo;
    }

    @Override
    public String registerBook(Book book) {
        Book bookDb = bRepo.save(book);
        return "Book added successfully with Id: " + bookDb.getId();
    }

    @Override
    public Book fetchBookById(Integer id) {
        bRepo.findById(id);
        return bRepo.findById(id).orElseThrow(() -> new BookStoreException("Book not found with Id: " + id));
    }

    @Override
    public List<Book> fetAllBooks() {
        return bRepo.findAll();
    }

    @Override
    public String updateBookData(Book book) {

        Optional<Book> optional = bRepo.findById(book.getId());
        if (optional.isPresent()) {
            bRepo.save(book);
            return "Book info with id " + book.getId() + " updated";
        } else {
            throw new BookStoreException("Book with Id :" + book.getId() + " is not present in the records to update");
        }
    }

    @Override
    public String updateBookDataById(Integer id, Double price) {
        Optional<Book> optional = bRepo.findById(id);

        if (optional.isPresent()) {
            Book book = optional.get();
            book.setBPrice(price);
            bRepo.save(book);
            return "Book with Id: " + id + " updated";
        } else {
            throw new BookStoreException("Book with Id :" + id + " is not present in the records to update");
        }
    }

    @Override
    public String deleteBook(Integer id) {
        Optional<Book> optional = bRepo.findById(id);
        if (optional.isPresent()) {
            bRepo.deleteById(id);
            return "Book with Id: " + id + " deleted";
        } else {
            throw new BookStoreException("Book with Id :" + id + " is not present in the records to delete");
        }
    }
}
