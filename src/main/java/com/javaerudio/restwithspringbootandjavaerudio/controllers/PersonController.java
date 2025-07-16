package com.javaerudio.restwithspringbootandjavaerudio.controllers;

import com.javaerudio.restwithspringbootandjavaerudio.data.v1.PersonDTO;
import com.javaerudio.restwithspringbootandjavaerudio.data.v2.PersonDTOV2;
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
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<PersonDTO> findAll () {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PostMapping(value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
        return service.createV2(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


