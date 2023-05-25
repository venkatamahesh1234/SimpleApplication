package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
