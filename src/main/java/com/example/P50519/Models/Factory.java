package com.example.P50519.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String name;

    @ManyToMany
    @JoinTable (name = "tovars_factory",
            joinColumns = @JoinColumn(name = "factory_id"),
            inverseJoinColumns = @JoinColumn(name = "tovar_id"))
    private List<Tovar> tovars;

    public Factory() {
    }

    public Factory(String address, String name) {
        this.address = address;
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tovar> getTovars() {
        return tovars;
    }

    public void setTovars(List<Tovar> tovars) {
        this.tovars = tovars;
    }
}
