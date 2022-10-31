package com.example.P50519.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Tovar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле не должно быть пустым!")
    @Size(min = 1, max = 150, message = "Поле должно содержать от 1 до 150 символов")
    private String tovarName;

    @NotBlank(message = "Поле не должно быть пустым!")
    private String tovarColor;


    @NotNull(message = "Поле не моет быть пустым")
    @Max(value = 999999999, message = "Стоимость не может превышать больше 999 млн.")
    @Min(value = 1, message = "Стоимость не может быть меньше 1")
    //@Positive(message = "Стоимость должна быть положительной!")
    //@PositiveOrZero - Положительное или 0
    //@Negative - Отрицательное число
    //@NegativeOrZero - Отрицательное или 0
    //DecimalMax()
    //DecimalMin()
    private Integer tovarCost;

    //@NotBlank(message = "Поле не должно быть пустым!")
    //@Past(message = "Дата рождения не может быть в настоящем или будущем") //Прошлое
    //@PastOrPresent - Прошлое или настоящее
    //@Future - Будущее
    //@FutureOrPresent - Будущее или настроящее
    @NotNull(message = "Поле не может быть пустым")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]", message = "Дата не соотвествует маске ввода")
    private String tovarDelivery;


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

    public String getTovarColor() {
        return tovarColor;
    }

    public void setTovarColor(String tovarColor) {
        this.tovarColor = tovarColor;
    }


    public Integer getTovarCost() {
        return tovarCost;
    }

    public void setTovarCost(Integer tovarCost) {
        this.tovarCost = tovarCost;
    }

    public String getTovarDelivery() {
        return tovarDelivery;
    }

    public void setTovarDelivery(String tovarDelivery) {
        this.tovarDelivery = tovarDelivery;
    }

    public Tovar() { }

    public Tovar(String tovarName, String tovarColor, Integer tovarCost, String tovarDelivery) {
        this.tovarName = tovarName;
        this.tovarColor = tovarColor;
        this.tovarCost = tovarCost;
        this.tovarDelivery = tovarDelivery;
    }
}
