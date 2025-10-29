package com.utangnaloob.utangnaloob.repositories;

import com.utangnaloob.utangnaloob.models.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Long> {
}
