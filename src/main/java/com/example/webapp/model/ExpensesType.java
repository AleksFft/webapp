package com.example.webapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "EXPENSES_TYPE")
@EqualsAndHashCode(callSuper = false)
public class ExpensesType extends CommonEntity {

    @Column(name = "EXPENSES_NAME")
    private String expensesName;

    @Column(name = "MDS")
    private Long mds;
}
