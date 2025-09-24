package com.javaerudio.restwithspringbootandjavaerudio.unitetests.mapper.mocks;

import com.javaerudio.restwithspringbootandjavaerudio.data.dto.BookDTO;
import com.javaerudio.restwithspringbootandjavaerudio.model.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookDTO> mockDTOList() {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < 14 ; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }

    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setAuthor("Author test" + number);
        book.setTitle("Title test" + number);
        book.setLaunchDate(LocalDateTime.now());
        book.setPrice(new BigDecimal(10));
        book.setId(number.longValue());
        return book;
    }

    public BookDTO mockDTO(Integer number) {
        BookDTO book = new BookDTO();
        book.setAuthor("Author test" + number);
        book.setTitle("Title test" + number);
        book.setLauchDate(LocalDateTime.now());
        book.setPrice(new BigDecimal(10));
        book.setId(number.longValue());
        return book;
    }





}
