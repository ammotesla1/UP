package com.example.UP.Repositories;

import com.example.UP.Models.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaterialRepo extends CrudRepository<Material,Long> {
    public Material findByNameMaterial(String name);
}
