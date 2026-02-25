package ru.zyryanova.ProductService.entity;

import jakarta.persistence.*;
import ru.zyryanova.ProductService.enums.Groups;

@Entity
@Table(name = "product_classification_score")
public class ProductClassificationScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_сlassification_score_id")
    private int productClassificationScoreId;

    @Column(name = "product_id")
    @OneToOne
    private int productId;

    @Column(name = "humecants")
    private int humecants;

    @Column(name = "emollients")
    private int emolloents;

    @Column(name = "proteins")
    private int proteins;

    @Column(name = "drying_alcohols")
    private int dryingAlcohols;

    @Column(name = "heavy_oils")
    private int heavy_oils;

    public ProductClassificationScore() {
    }

    public int getProductClassificationScoreId() {
        return productClassificationScoreId;
    }

    public void setProductClassificationScoreId(int productClassificationScoreId) {
        this.productClassificationScoreId = productClassificationScoreId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getHumecants() {
        return humecants;
    }

    public void setHumecants(int humecants) {
        this.humecants = humecants;
    }

    public int getEmolloents() {
        return emolloents;
    }

    public void setEmolloents(int emolloents) {
        this.emolloents = emolloents;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getDryingAlcohols() {
        return dryingAlcohols;
    }

    public void setDryingAlcohols(int dryingAlcohols) {
        this.dryingAlcohols = dryingAlcohols;
    }

    public int getHeavy_oils() {
        return heavy_oils;
    }

    public void setHeavy_oils(int heavy_oils) {
        this.heavy_oils = heavy_oils;
    }

    public void increment(Groups groups) {
        switch (groups) {
            case HUMECTANTS -> humecants++;
            case EMOLLIENTS -> emolloents++;
            case PROTEINS -> proteins++;
            case DRYING_ALCOHOLS -> dryingAlcohols++;
            case HEAVY_OILS -> heavy_oils++;
        }
    }

}


