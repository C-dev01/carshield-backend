package com.carshield.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carshield.backend.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {}