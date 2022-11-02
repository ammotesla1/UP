package com.example.UP.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Order_")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateOfRelease;
    @ManyToOne(optional = true)
    private Client client;
    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "ID_Order"),
            inverseJoinColumns = @JoinColumn(name = "ID_Product"))
    private List<Product> product;

    @OneToOne(optional = true, mappedBy = "order")
    private Check check;

    public Order(String dateOfRelease, Client client){
        this.dateOfRelease = dateOfRelease;
        this.client = client;
    }

    public Order() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
}
