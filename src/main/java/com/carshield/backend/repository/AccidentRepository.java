package com.carshield.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carshield.backend.entity.Accident;

public interface AccidentRepository extends JpaRepository<Accident, Integer> {}
