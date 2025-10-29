package com.utangnaloob.utangnaloob.repositories;

import com.utangnaloob.utangnaloob.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
