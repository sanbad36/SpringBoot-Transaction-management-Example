package com.Sanket.SpringbootTransaction.repository;

import com.Sanket.SpringbootTransaction.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
