package com.example.P50519.Repositories;

import com.example.P50519.Models.TovarColor;
import org.springframework.data.repository.CrudRepository;

public interface TovarColorRepository extends CrudRepository<TovarColor, Long> {
    TovarColor findByMainColor(String carColor);
}
