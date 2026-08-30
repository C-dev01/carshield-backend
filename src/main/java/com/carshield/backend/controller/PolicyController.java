package com.carshield.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carshield.backend.entity.Policy;
import com.carshield.backend.repository.PolicyRepository;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = "*")
public class PolicyController {

    private final PolicyRepository policyRepo;

    public PolicyController(PolicyRepository policyRepo) {
        this.policyRepo = policyRepo;
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyRepo.findAll();
    }
}