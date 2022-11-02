package com.example.UP.Repositories;

import com.example.UP.Models.Shift;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShiftRepo extends CrudRepository<Shift, Long> {
    public Shift findByNameShift(String name);
    public Shift findByNameShiftContaining(String name);
}
