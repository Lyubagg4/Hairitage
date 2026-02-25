package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;

@Entity
@Table(name = "hair_type")
public class HairType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hair_type_id")
    private Integer hairTypeId;

    @Column(name = "hair_type_name", nullable = false, unique = true)
    private String hairTypeName;

    public HairType() {
    }

    public Integer getHairTypeId() {
        return hairTypeId;
    }

    public void setHairTypeId(Integer hairTypeId) {
        this.hairTypeId = hairTypeId;
    }

    public String getHairTypeName() {
        return hairTypeName;
    }

    public void setHairTypeName(String hairTypeName) {
        this.hairTypeName = hairTypeName;
    }
}