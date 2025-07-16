package com.javaerudio.restwithspringbootandjavaerudio.services;

import com.javaerudio.restwithspringbootandjavaerudio.data.v1.PersonDTO;
import com.javaerudio.restwithspringbootandjavaerudio.data.v2.PersonDTOV2;
import com.javaerudio.restwithspringbootandjavaerudio.exception.ResourceNotFoundException;
import static com.javaerudio.restwithspringbootandjavaerudio.mapper.ObjectMapper.parseListObject;
import static com.javaerudio.restwithspringbootandjavaerudio.mapper.ObjectMapper.parseObject;

import com.javaerudio.restwithspringbootandjavaerudio.mapper.custom.PersonMapper;
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

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll(){
        logger.info("Finding all persons");
        return parseListObject(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating a new person");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity),
                PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        logger.info("Creating a new person V2");
        var entity = converter.convertToEntity(person);

        return converter.convertToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating a person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity),
                PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting a person");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }
}
