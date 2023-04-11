package com.example.UP.Models;

import javax.persistence.*;
import java.util.Collection;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Bucket")
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProduct;
    private Integer amount;
    private Double weight;
    private Double price;
    private String dateOfProduction;
    private String imageProduct;
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;
    @ManyToOne(cascade = CascadeType.ALL)
    private Warehouse warehouse;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<Plan> plan;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<Order> order;

    public Bucket(String nameProduct, Integer amount, Double weight, Double price, String dateOfProduction,String imageProduct, Supplier supplier, Warehouse warehouse){
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.weight = weight;
        this.price = price;
        this.dateOfProduction = dateOfProduction;
        this.supplier = supplier;
        this.warehouse = warehouse;
        this.imageProduct = imageProduct;
    }

    public Bucket() {}

    public Long getId2() {
        return id;
    }

    public void setId2(Long id) {
        this.id = id;
    }

    public String getNameProduct2() {
        return nameProduct;
    }

    public void setNameProduct2(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getAmount2() {
        return amount;
    }

    public void setAmount2(Integer amount) {
        this.amount = amount;
    }

    public Double getWeight2() {
        return weight;
    }

    public void setWeight2(Double weight) {
        this.weight = weight;
    }

    public Double getPrice2() {
        return price;
    }

    public void setPrice2(Double price) {
        this.price = price;
    }

    public String getDateOfProduction2() {
        return dateOfProduction;
    }

    public void setDateOfProduction2(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public Supplier getSupplier2() {
        return supplier;
    }

    public void setSupplier2(Supplier supplier) {
        this.supplier = supplier;
    }

    public Warehouse getWarehouse2() {
        return warehouse;
    }

    public void setWarehouse2(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Collection<Order> getOrder2() {
        return order;
    }

    public void setOrder2(Collection<Order> order) {
        this.order = order;
    }

    public Collection<Plan> getPlan2() {
        return plan;
    }

    public void setPlan2(Collection<Plan> plan) {
        this.plan = plan;
    }

    public String getImageProduct2() {
        return imageProduct;
    }

    public void setImageProduct2(String imageProduct) {
        this.imageProduct = imageProduct;
    }
}
