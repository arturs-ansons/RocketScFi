package com.example.RocketScFi.model;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends ListCrudRepository<Crew, Long> { }
