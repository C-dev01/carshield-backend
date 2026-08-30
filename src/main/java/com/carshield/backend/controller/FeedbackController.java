package com.carshield.backend.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carshield.backend.entity.Feedback;
import com.carshield.backend.repository.FeedbackRepository;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    private final FeedbackRepository feedbackRepo;

    public FeedbackController(FeedbackRepository feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    @PostMapping
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        feedback.setCreatedAt(LocalDateTime.now());
        return feedbackRepo.save(feedback);
    }
}