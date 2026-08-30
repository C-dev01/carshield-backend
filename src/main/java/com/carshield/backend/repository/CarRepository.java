package com.carshield.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carshield.backend.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {}
