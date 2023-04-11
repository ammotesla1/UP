package com.example.UP.Repositories;

import com.example.UP.Models.Bucket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BucketRepo extends CrudRepository<Bucket, Long> {
    public List<Bucket> findByNameProduct(String name);
    public List<Bucket> findByNameProductContaining(String name);
}
