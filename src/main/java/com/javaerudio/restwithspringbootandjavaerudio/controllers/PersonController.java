package com.javaerudio.restwithspringbootandjavaerudio.controllers;

import com.javaerudio.restwithspringbootandjavaerudio.model.Person;
import com.javaerudio.restwithspringbootandjavaerudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<Person> findAll () {
        return service.findAll();
    }


    @PostMapping()
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping()
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


