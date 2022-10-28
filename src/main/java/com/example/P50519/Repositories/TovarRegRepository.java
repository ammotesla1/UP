package com.example.P50519.Repositories;

import com.example.P50519.Models.TovarReg;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TovarRegRepository extends CrudRepository<TovarReg, Long> {

    TovarReg findBySign(String sign);
}
