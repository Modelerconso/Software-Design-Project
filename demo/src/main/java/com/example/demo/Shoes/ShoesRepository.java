package com.example.demo.Shoes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends CrudRepository<Shoes, Integer> {
    
}
