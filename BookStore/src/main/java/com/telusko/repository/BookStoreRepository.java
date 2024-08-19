package com.telusko.repository;

import com.telusko.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<Book, Integer> {
}
