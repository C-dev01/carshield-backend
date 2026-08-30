package com.carshield.backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carshield.backend.dto.PurchaseRequestDto;
import com.carshield.backend.entity.Accident;
import com.carshield.backend.entity.Car;
import com.carshield.backend.entity.CustPolicies;
import com.carshield.backend.entity.Customer;
import com.carshield.backend.entity.Payment;
import com.carshield.backend.entity.Policy;
import com.carshield.backend.repository.AccidentRepository;
import com.carshield.backend.repository.CarRepository;
import com.carshield.backend.repository.CustPoliciesRepository;
import com.carshield.backend.repository.CustomerRepository;
import com.carshield.backend.repository.PaymentRepository;
import com.carshield.backend.repository.PolicyRepository;

@Service
public class InsuranceService {

    private final CustomerRepository customerRepo;
    private final CarRepository carRepo;
    private final AccidentRepository accidentRepo;
    private final PolicyRepository policyRepo;
    private final CustPoliciesRepository custPoliciesRepo;
    private final PaymentRepository paymentRepo;

    public InsuranceService(CustomerRepository customerRepo, CarRepository carRepo,
                            AccidentRepository accidentRepo, PolicyRepository policyRepo,
                            CustPoliciesRepository custPoliciesRepo, PaymentRepository paymentRepo) {
        this.customerRepo = customerRepo;
        this.carRepo = carRepo;
        this.accidentRepo = accidentRepo;
        this.policyRepo = policyRepo;
        this.custPoliciesRepo = custPoliciesRepo;
        this.paymentRepo = paymentRepo;
    }

    @Transactional
    public CustPolicies processPurchase(PurchaseRequestDto dto) {
        // 1. Get or Create Customer
        Customer customer = customerRepo.findByEmail(dto.getEmail())
                .orElseGet(() -> customerRepo.save(new Customer(dto.getName(), dto.getEmail(), dto.getPhone())));

        // 2. Save Car
        Car car = new Car();
        car.setCustomer(customer);
        car.setModel(dto.getModel());
        car.setRegistrationNumber(dto.getRegistrationNumber());
        car.setManufactureYear(dto.getManufactureYear());
        car = carRepo.save(car);

        // 3. Save Accident record if logged
        if (dto.getAccidentCount() != null && dto.getAccidentCount() > 0 && dto.getAccidentDate() != null) {
            Accident accident = new Accident();
            accident.setCar(car);
            accident.setAccidentDate(dto.getAccidentDate());
            accident.setLocation(dto.getAccidentLocation());
            accident.setDescription(dto.getAccidentDescription());
            accident.setDamageCost(dto.getDamageCost());
            accidentRepo.save(accident);
        }

        // 4. Fetch Selected Policy
        Policy policy = policyRepo.findById(dto.getPolicyId())
                .orElseThrow(() -> new RuntimeException("Policy not found with ID: " + dto.getPolicyId()));

        // 5. Create Cust_Policies Record (Junction entity)
        CustPolicies custPolicy = new CustPolicies();
        custPolicy.setCustomer(customer);
        custPolicy.setCar(car);
        custPolicy.setPolicy(policy);
        custPolicy.setStartDate(LocalDate.now());
        custPolicy.setEndDate(LocalDate.now().plusMonths(policy.getDurationMonths()));
        custPolicy.setStatus("ACTIVE");
        custPolicy = custPoliciesRepo.save(custPolicy);

        // 6. Create Payment Record
        Payment payment = new Payment();
        payment.setCustPolicies(custPolicy);
        payment.setAmount(policy.getPremiumAmount());
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentStatus("SUCCESS");
        paymentRepo.save(payment);

        return custPolicy;
    }
}