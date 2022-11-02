package com.example.UP.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private boolean active;
    private String surname;
    private String name;
    private String middleName;
    @Pattern(regexp = "\\+7\\([0-9][0-9][0-9]\\)[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]", message = "+7(XXX)XXX-XX-XX")
    private String phone;
    @ElementCollection(targetClass = Post.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "post", joinColumns = @JoinColumn(name = "id_employee"))
    @Enumerated(EnumType.STRING)
    private Set<Post> post;
    @ManyToOne(optional = true)
    private Shift shift;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Collection<Plan> plan;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Collection<Check> check;

    public Employee(String email, String password, Boolean active, String surname, String name, String middleName, String phone, Set<Post> post, Shift shift) {
        this.email = email;
        this.password = password;
        this.active = active;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.phone = phone;
        this.post = post;
        this.shift = shift;
    }

    public Employee() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Post> getPost() {
        return post;
    }

    public void setPost(Set<Post> post) {
        this.post = post;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Collection<Plan> getPlan() {
        return plan;
    }

    public void setPlan(Collection<Plan> plan) {
        this.plan = plan;
    }

    public Collection<Check> getCheck() {
        return check;
    }

    public void setCheck(Collection<Check> check) {
        this.check = check;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
