package com.example.UP.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Plan_")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateOfRegistration;
    @ManyToMany
    @JoinTable(name="plan_product",
        joinColumns = @JoinColumn(name = "ID_Plan"),
        inverseJoinColumns = @JoinColumn(name = "ID_Product"))
    private List<Product> product;
    @ManyToOne(optional = true)
    private Supplier supplier;
    @ManyToOne(optional = true)
    private Employee employee;

    public Plan(String dateOfRegistration, Supplier supplier, Employee employee){
        this.dateOfRegistration = dateOfRegistration;
        this.supplier = supplier;
        this.employee = employee;
    }

    public Plan() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
