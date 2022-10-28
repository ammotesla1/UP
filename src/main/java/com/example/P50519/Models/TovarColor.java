package com.example.P50519.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "colors")
public class TovarColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mainColor;

    private String subColor;

    @OneToMany(mappedBy = "tovarColor", fetch = FetchType.EAGER) // Ссылается на столбик (tovarColor из таблицы машин) и
    private Collection<Tovar> tovars;                              // стратерия загрузок - EAGER (объекты коллекции сразу загружаются)

    public TovarColor() {
    }

    public TovarColor(String mainColor, String subColor) {
        this.mainColor = mainColor;
        this.subColor = subColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getSubColor() {
        return subColor;
    }

    public void setSubColor(String subColor) {
        this.subColor = subColor;
    }

    public Collection<Tovar> getTovars() {
        return tovars;
    }

    public void setTovars(Collection<Tovar> tovars) {
        this.tovars = tovars;
    }
}
