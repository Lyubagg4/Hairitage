package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Integer ingredientId;

    @Column(name = "ingredient_name", nullable = false)
    private String ingredientName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purpose_ing_id")
    private PurposeIng purposeIng;

    public Ingredient() {
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public PurposeIng getPurposeIng() {
        return purposeIng;
    }

    public void setPurposeIng(PurposeIng purposeIng) {
        this.purposeIng = purposeIng;
    }
}