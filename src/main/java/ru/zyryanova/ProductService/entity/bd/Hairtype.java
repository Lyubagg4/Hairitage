package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;

@Entity
@Table(name = "hairtype")
public class Hairtype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hairtype_id")
    private Integer hairtypeId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Hairtype() {
    }

    public Integer getHairtypeId() {
        return hairtypeId;
    }

    public void setHairtypeId(Integer hairtypeId) {
        this.hairtypeId = hairtypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}