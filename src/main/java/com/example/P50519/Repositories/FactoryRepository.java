package com.example.P50519.Repositories;

import com.example.P50519.Models.Factory;
import org.springframework.data.repository.CrudRepository;

public interface FactoryRepository extends CrudRepository<Factory, Long> {
    Factory findByName(String name);
}