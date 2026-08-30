package com.carshield.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carshield.backend.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {}