package com.example.P50519.Models;

import javax.persistence.*;

@Entity
@Table(name = "tovarreg")
public class TovarReg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sign;

    private String INN;

    @OneToOne(mappedBy = "registration")
    private Tovar tovar;

    public TovarReg() {
    }

    public TovarReg(String sign, String INN) {
        this.sign = sign;
        this.INN = INN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }
}