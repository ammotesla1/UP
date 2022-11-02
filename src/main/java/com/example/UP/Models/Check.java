package com.example.UP.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Check_")
public class Check {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateOfRelease;
    @OneToOne(optional = true)
    @JoinColumn(name="ID_Order")
    private Order order;
    @ManyToOne(optional = true)
    private Employee employee;
    @ManyToOne(optional = true)
    private Client client;
    @ManyToOne(optional = true)
    private Shift shift;

    public Check(String dateOfRelease, Order order, Employee employee, Client client, Shift shift){
        this.dateOfRelease = dateOfRelease;
        this.order = order;
        this.employee = employee;
        this.client = client;
        this.shift = shift;
    }

    public Check() {}

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
