package com.example.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.dojosninjas.models.Ninja;

public interface NinjaRepoPage extends PagingAndSortingRepository<Ninja,Long> {
    
    List<Ninja> findAll();
}
