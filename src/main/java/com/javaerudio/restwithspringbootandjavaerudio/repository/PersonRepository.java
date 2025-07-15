package com.javaerudio.restwithspringbootandjavaerudio.repository;

import com.javaerudio.restwithspringbootandjavaerudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
