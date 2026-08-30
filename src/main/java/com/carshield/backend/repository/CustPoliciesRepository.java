package com.carshield.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carshield.backend.entity.CustPolicies;

public interface CustPoliciesRepository extends JpaRepository<CustPolicies, Integer> {}