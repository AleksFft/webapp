package com.example.webapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "COMPANY")
@EqualsAndHashCode(callSuper = false)
public class Company extends CommonEntity {

    @NotEmpty
    @Column(name = "COMPANY_NAME")
    private String companyName;
}
