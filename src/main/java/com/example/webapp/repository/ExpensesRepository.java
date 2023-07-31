package com.example.webapp.repository;

import com.example.webapp.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    @Query("select e from Expenses e where e.expensesType.expensesName = :name and e.expensesAmount = :amount")
    Expenses findExpensesByNameAndAmount(@Param("name") String name, @Param("amount") Long amount);

    @Query("select e.expensesType.mds as mds, sum(e.expensesAmount) from Expenses e " +
            "where e.expensesType.expensesName = :name " +
            "group by e.expensesType.mds")
    String sumAmountAndMds(@Param("name") String name);
}
