package com.example.twilio_demo.repository;


import com.example.twilio_demo.Models.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Long> {
}
