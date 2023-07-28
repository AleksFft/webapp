package com.example.webapp.repository;

import com.example.webapp.model.ExpensesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesTypeRepository extends JpaRepository<ExpensesType, Long> {
}
