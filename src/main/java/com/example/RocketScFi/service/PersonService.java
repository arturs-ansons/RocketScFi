package com.example.RocketScFi.service;

import com.example.RocketScFi.dto.PersonDTO;
import com.example.RocketScFi.dto.PersonResponse;
import com.example.RocketScFi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean save(PersonDTO personDTO) {
        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        personRepository.save(person);
        return true;
    }

    public Optional<PersonResponse> findById(long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()) {
            return Optional.empty();
        }
        Person person = personOptional.get();
        PersonResponse personResponse = new PersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName()
        );
        return Optional.of(personResponse);
    }

    public List<PersonResponse> findAll() {
        return personRepository
                .findAll()
                .stream()
                .map(e -> new PersonResponse(e.getId(), e.getFirstName(), e.getLastName()))
                .toList();
    }
}
