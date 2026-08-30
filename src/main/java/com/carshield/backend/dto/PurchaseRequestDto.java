package com.carshield.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseRequestDto {

    // Customer details
    private String name;
    private String email;
    private String phone;

    // Car details
    private String model;
    private String registrationNumber;
    private Integer manufactureYear;

    // Accident details (optional)
    private Integer accidentCount;
    private LocalDate accidentDate;
    private String accidentLocation;
    private String accidentDescription;
    private BigDecimal damageCost;

    // Policy selected
    private Integer policyId;

    public PurchaseRequestDto() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public Integer getManufactureYear() { return manufactureYear; }
    public void setManufactureYear(Integer manufactureYear) { this.manufactureYear = manufactureYear; }
    public Integer getAccidentCount() { return accidentCount; }
    public void setAccidentCount(Integer accidentCount) { this.accidentCount = accidentCount; }
    public LocalDate getAccidentDate() { return accidentDate; }
    public void setAccidentDate(LocalDate accidentDate) { this.accidentDate = accidentDate; }
    public String getAccidentLocation() { return accidentLocation; }
    public void setAccidentLocation(String accidentLocation) { this.accidentLocation = accidentLocation; }
    public String getAccidentDescription() { return accidentDescription; }
    public void setAccidentDescription(String accidentDescription) { this.accidentDescription = accidentDescription; }
    public BigDecimal getDamageCost() { return damageCost; }
    public void setDamageCost(BigDecimal damageCost) { this.damageCost = damageCost; }
    public Integer getPolicyId() { return policyId; }
    public void setPolicyId(Integer policyId) { this.policyId = policyId; }
}