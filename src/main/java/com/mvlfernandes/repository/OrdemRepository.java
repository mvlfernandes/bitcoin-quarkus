package com.mvlfernandes.repository;

import javax.enterprise.context.ApplicationScoped;

import com.mvlfernandes.model.Ordem;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
    
}
