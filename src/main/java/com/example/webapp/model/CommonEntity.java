package com.example.webapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class CommonEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
