package com.example.UP.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "Shift_")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameShift;
    private String date_Start_Shift;
    private String date_End_Shift;

    @OneToMany(mappedBy = "shift", fetch = FetchType.LAZY)
    private Collection<Employee> employee;
    @OneToMany(mappedBy = "shift", fetch = FetchType.LAZY)
    private Collection<Check> check;

    public Shift(String nameShift, String date_Start_Shift, String date_End_Shift){
        this.nameShift = nameShift;
        this.date_Start_Shift = date_Start_Shift;
        this.date_End_Shift = date_End_Shift;
    }

    public Shift() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameShift() {
        return nameShift;
    }

    public void setNameShift(String nameShift) {
        this.nameShift = nameShift;
    }

    public String getDate_Start_Shift() {
        return date_Start_Shift;
    }

    public void setDate_Start_Shift(String date_Start_Shift) {
        this.date_Start_Shift = date_Start_Shift;
    }

    public String getDate_End_Shift() {
        return date_End_Shift;
    }

    public void setDate_End_Shift(String date_End_Shift) {
        this.date_End_Shift = date_End_Shift;
    }

    public Collection<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Collection<Employee> employee) {
        this.employee = employee;
    }

    public Collection<Check> getCheck() {
        return check;
    }

    public void setCheck(Collection<Check> check) {
        this.check = check;
    }
}
