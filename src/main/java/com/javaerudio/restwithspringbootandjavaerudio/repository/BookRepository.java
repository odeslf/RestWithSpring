package com.javaerudio.restwithspringbootandjavaerudio.repository;

import com.javaerudio.restwithspringbootandjavaerudio.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
