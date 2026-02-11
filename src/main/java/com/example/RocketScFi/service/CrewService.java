package com.example.RocketScFi.service;

import com.example.RocketScFi.dto.CrewDTO;
import com.example.RocketScFi.dto.CrewResponse;
import com.example.RocketScFi.model.*;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class CrewService {
    private final PersonRepository personRepository;
    private final CrewRepository crewRepository;

    public CrewService(PersonRepository personRepository, CrewRepository crewRepository) {
        this.personRepository = personRepository;
        this.crewRepository = crewRepository;
    }

    public boolean save(CrewDTO crewDTO) {
        for (Long personId : crewDTO.getPeople()) {
            if (personRepository.findById(personId).isEmpty()) {
                return false;
            }
        }
        List<Long> ids = new ArrayList<>();
        for (Long person : crewDTO.getPeople()) {
            if (ids.contains(person)) {
                return false;
            }
            ids.add(person);
        }

        Crew crew = new Crew();
        for (Long id : ids) {
            Optional<Person> optionalPerson = personRepository.findById(id);
            if (optionalPerson.isEmpty()) {
                continue;
            }
            Person person = optionalPerson.get();
            person.setCrew(crew);
        }
        crewRepository.save(crew);
        return true;
    }

    public boolean deleteById(long id) {
        if (findById(id).isEmpty()) {
            return false;
        }

        crewRepository.deleteById(id);
        return true;
    }


    public Optional<CrewResponse> findById(long id) {
        Optional<Crew> crewOptional = crewRepository.findById(id);
        if (crewOptional.isEmpty()) {
            return Optional.empty();
        }
        Crew crew = crewOptional.get();
        CrewResponse crewResponse = new CrewResponse(
                crew.getId(),
                crew.getPeople().stream().map(Person::getId).toList()
        );
        return Optional.of(crewResponse);
    }

    public List<CrewResponse> findAll() {
        return crewRepository
                .findAll()
                .stream()
                .map(e -> new CrewResponse(e.getId(), e.getPeople().stream().map(Person::getId).toList()))
                .toList();
    }
}
