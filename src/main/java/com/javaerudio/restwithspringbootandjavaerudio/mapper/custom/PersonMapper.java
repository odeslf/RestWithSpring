package com.javaerudio.restwithspringbootandjavaerudio.mapper.custom;

import com.javaerudio.restwithspringbootandjavaerudio.data.v2.PersonDTOV2;
import com.javaerudio.restwithspringbootandjavaerudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertToDTO(Person person) {
        PersonDTOV2 personDTO = new PersonDTOV2();
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setAddress(person.getAddress());
        personDTO.setDateOfBirth(new Date());
        personDTO.setGender(person.getGender());
        return personDTO;
    }

    public Person convertToEntity(PersonDTOV2 personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setAddress(personDTO.getAddress());
        person.setGender(personDTO.getGender());
        return person;
    }
}
