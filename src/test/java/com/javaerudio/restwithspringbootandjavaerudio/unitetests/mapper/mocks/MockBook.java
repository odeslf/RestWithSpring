package br.com.erudio.unitetests.mapper.mocks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javaerudio.restwithspringbootandjavaerudio.data.dto.BookDTO;
import com.javaerudio.restwithspringbootandjavaerudio.model.Book;


public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<com.javaerudio.restwithspringbootandjavaerudio.model.Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookDTO> mockDTOList() {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }
    
    public com.javaerudio.restwithspringbootandjavaerudio.model.Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(LocalDateTime.now());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }

    public com.javaerudio.restwithspringbootandjavaerudio.data.dto.BookDTO mockDTO(Integer number) {
        BookDTO book = new BookDTO();
        book.setId(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(LocalDateTime.now());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }

}