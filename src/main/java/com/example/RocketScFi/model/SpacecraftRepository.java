package com.example.RocketScFi.model;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpacecraftRepository extends ListCrudRepository<Spacecraft, Long> { }
