package com.example.UP.Repositories;

import com.example.UP.Models.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductTypeRepo extends CrudRepository<ProductType, Long> {
    public ProductType findByNameType(String name);
    public List<ProductType> findByNameTypeContaining(String name);
}
