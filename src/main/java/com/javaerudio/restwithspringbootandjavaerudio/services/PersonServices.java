package com.javaerudio.restwithspringbootandjavaerudio.services;

import com.javaerudio.restwithspringbootandjavaerudio.exception.ResourceNotFoundException;
import com.javaerudio.restwithspringbootandjavaerudio.model.Person;
import com.javaerudio.restwithspringbootandjavaerudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all persons");
        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Person create(Person person){
        logger.info("Creating a new person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating a person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting a person");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }
}
