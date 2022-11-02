package com.example.UP.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "Warehouse_")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    private String address;
    @NotNull(message = "Поле не должно быть пустым")
    private Integer capacity;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.EAGER)
    private Collection<Product> product;

    public Warehouse(String address, Integer capacity){
        this.address = address;
        this.capacity = capacity;
    }

    public Warehouse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Collection<Product> getProduct() {
        return product;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }
}
