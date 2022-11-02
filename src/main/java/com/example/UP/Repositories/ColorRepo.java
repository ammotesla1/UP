package com.example.UP.Repositories;

import com.example.UP.Models.Color;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColorRepo extends CrudRepository<Color, Long> {
    public Color findByNameColor(String NameColor);
    public List<Color> findByNameColorContaining(String name);
}
