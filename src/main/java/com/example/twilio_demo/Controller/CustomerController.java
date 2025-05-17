package com.example.twilio_demo.Controller;

import com.example.twilio_demo.Models.CustomerDetail;
import com.example.twilio_demo.repository.CustomerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @PostMapping
    public ResponseEntity<CustomerDetail> saveCustomer(@RequestBody CustomerDetail customerDetail) {
        CustomerDetail saved = customerDetailRepository.save(customerDetail);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<CustomerDetail> getAllCustomers() {
        return customerDetailRepository.findAll();
    }
}
