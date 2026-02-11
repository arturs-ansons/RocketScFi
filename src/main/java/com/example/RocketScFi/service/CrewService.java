package com.example.RocketScFi.service;

import com.example.RocketScFi.dto.CrewDTO;
import com.example.RocketScFi.dto.CrewResponse;
import com.example.RocketScFi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrewService {
    private final PersonService personService;
    private final CrewRepository crewRepository;

    public CrewService(PersonService personService, CrewRepository crewRepository) {
        this.personService = personService;
        this.crewRepository = crewRepository;
    }

    public boolean save(CrewDTO crewDTO) {
        for (Long personId : crewDTO.getPeople()) {
            if (personService.findById(personId).isEmpty()) {
                return false;
            }
        }
        Crew crew = new Crew();
        crew.setPeople(crewDTO.getPeople());
        crewRepository.save(crew);
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
                crew.getPeople()
        );
        return Optional.of(crewResponse);
    }

    public List<CrewResponse> findAll() {
        return crewRepository
                .findAll()
                .stream()
                .map(e -> new CrewResponse(e.getId(), e.getPeople()))
                .toList();
    }
}
