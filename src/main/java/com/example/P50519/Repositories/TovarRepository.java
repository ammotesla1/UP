package com.example.P50519.Repositories;
import com.example.P50519.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TovarRepository extends CrudRepository<Tovar, Long> {

    Tovar findByTovarName(String name);
    public List<Tovar> findByTovarNameContains(String name);
}