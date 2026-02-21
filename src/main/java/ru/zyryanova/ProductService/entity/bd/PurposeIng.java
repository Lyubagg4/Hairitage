package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;

@Entity
@Table(name = "purpose_ing")
public class PurposeIng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purpose_ing_id")
    private Integer purposeIngId;

    @Column(name = "name")
    private String name;

    public PurposeIng() {
    }

    public Integer getPurposeIngId() {
        return purposeIngId;
    }

    public void setPurposeIngId(Integer purposeIngId) {
        this.purposeIngId = purposeIngId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}