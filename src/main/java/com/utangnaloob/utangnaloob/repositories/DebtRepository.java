package com.utangnaloob.utangnaloob.repositories;

import com.utangnaloob.utangnaloob.models.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Long> {
}
