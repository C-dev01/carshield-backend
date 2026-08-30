package com.carshield.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_id")
    private Integer accidentId;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "accident_date", nullable = false)
    private LocalDate accidentDate;

    private String location;
    private String description;

    @Column(name = "damage_cost")
    private BigDecimal damageCost;

    public Accident() {}

    public Integer getAccidentId() { return accidentId; }
    public void setAccidentId(Integer accidentId) { this.accidentId = accidentId; }
    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
    public LocalDate getAccidentDate() { return accidentDate; }
    public void setAccidentDate(LocalDate accidentDate) { this.accidentDate = accidentDate; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getDamageCost() { return damageCost; }
    public void setDamageCost(BigDecimal damageCost) { this.damageCost = damageCost; }
}
