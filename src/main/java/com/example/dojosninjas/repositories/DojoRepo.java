package com.example.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dojosninjas.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo,Long> {
    
    List<Dojo> findAll();
}
