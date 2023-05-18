package com.example.dojosninjas.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja,Long> {
    
    List<Ninja> findAll();
}
