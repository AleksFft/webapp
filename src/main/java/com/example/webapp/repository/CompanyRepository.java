package com.example.webapp.repository;

import com.example.webapp.model.Company;
import com.example.webapp.model.ExpensesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select c from Company c where c.companyName = :name")
    Company findCompanyByName(@Param("name") String name);
}
