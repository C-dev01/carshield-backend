package com.carshield.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carshield.backend.dto.PurchaseRequestDto;
import com.carshield.backend.entity.CustPolicies;
import com.carshield.backend.service.InsuranceService;

@RestController
@RequestMapping("/api/insurance")
@CrossOrigin(origins = "*")
public class InsuranceController {

    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/purchase")
    public CustPolicies purchaseInsurance(@RequestBody PurchaseRequestDto dto) {
        return insuranceService.processPurchase(dto);
    }
}