package com.example.P50519.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tovar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tovarName;

    private Integer tovarCost;

    @OneToOne(cascade = CascadeType.ALL) //Создание связи один к одному с каскадным удалением для таблицы регистраций
    @JoinColumn(name = "reg_id") //Указываем столбец как внешний ключ
    private TovarReg registration;

    @ManyToOne(cascade = CascadeType.ALL) //Создание связи многие к одному с каскадным удалением для таблицы цветов
    private TovarColor tovarColor;

    @ManyToMany //Создание связи многие ко многим для таблицы автосалонов
    @JoinTable(name = "tovars_fuctory", // Создаём таблицу с заданным именем
            joinColumns = @JoinColumn(name = "tovar_id"), // Создём столбец отвечающий за внешний ключ из этой сущности
            inverseJoinColumns = @JoinColumn(name = "facroty_id")) // Создём столбец отвечающий за внешний ключ из другой сущности
    private List<Factory> factorys;

    public Tovar() {
    }

    public Tovar(String tovarName, Integer tovarCost, TovarReg registration, TovarColor tovarColor) {
        this.tovarName = tovarName;
        this.tovarCost = tovarCost;
        this.registration = registration;
        this.tovarColor = tovarColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTovarName() {
        return tovarName;
    }

    public void setTovarName(String tovarName) {
        this.tovarName = tovarName;
    }

    public Integer getTovarCost() {
        return tovarCost;
    }

    public void setTovarCost(Integer tovarCost) {
        this.tovarCost = tovarCost;
    }

    public TovarReg getRegistration() {
        return registration;
    }

    public void setRegistration(TovarReg registration) {
        this.registration = registration;
    }

    public TovarColor getTovarColor() {
        return tovarColor;
    }

    public void setTovarColor(TovarColor tovarColor) {
        this.tovarColor = tovarColor;
    }

    public List<Factory> getFactorys() {
        return factorys;
    }

    public void setFactorys(List<Factory> factorys) {
        this.factorys = factorys;
    }
}
