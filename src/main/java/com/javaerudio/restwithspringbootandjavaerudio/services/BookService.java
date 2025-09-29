package com.javaerudio.restwithspringbootandjavaerudio.services;

import com.javaerudio.restwithspringbootandjavaerudio.controllers.BookController;
import com.javaerudio.restwithspringbootandjavaerudio.data.dto.BookDTO;
import com.javaerudio.restwithspringbootandjavaerudio.exception.RequiredObjectIsNullException;
import com.javaerudio.restwithspringbootandjavaerudio.exception.ResourceNotFoundException;
import com.javaerudio.restwithspringbootandjavaerudio.model.Book;
import com.javaerudio.restwithspringbootandjavaerudio.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.javaerudio.restwithspringbootandjavaerudio.mapper.ObjectMapper.parseListObject;
import static com.javaerudio.restwithspringbootandjavaerudio.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    BookRepository repository;

    public List<BookDTO> findAll() {
        logger.info("Finding all books");
        var books = parseListObject(repository.findAll(), BookDTO.class);
        books.forEach(this::addHateoasLinks);
        return books;
    }

    public BookDTO findById(Long id){
        logger.info("Finding one book with id!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No records found for this id"));
        var dto = parseObject(entity, BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public BookDTO create(BookDTO book) {
        if(book == null) throw new RequiredObjectIsNullException();

        logger.info("Creating a new book");
        var entity = parseObject(book, Book.class);

        var dto = parseObject(repository.save(entity), BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public BookDTO update(BookDTO book) {
        if(book == null)throw new RequiredObjectIsNullException();
        logger.info("Updating a book");
        Book entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());
        entity.setTitle(book.getTitle());

        var dto = parseObject(repository.save(entity), BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id){
        logger.info("Deleting a book");
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

    private void addHateoasLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
