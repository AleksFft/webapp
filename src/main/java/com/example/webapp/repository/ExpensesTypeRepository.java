package com.example.webapp.repository;

import com.example.webapp.model.ExpensesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesTypeRepository extends JpaRepository<ExpensesType, Long> {

    @Query("select e from ExpensesType e where e.expensesName = :name")
    ExpensesType findExpensesTypeByName(@Param("name") String name);
}
