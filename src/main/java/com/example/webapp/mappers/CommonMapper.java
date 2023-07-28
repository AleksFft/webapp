package com.example.webapp.mappers;

public interface CommonMapper<M, D> {

    D toDto(M entity);
    M toEntity(D dto);
}
