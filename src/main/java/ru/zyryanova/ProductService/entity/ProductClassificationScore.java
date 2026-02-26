package ru.zyryanova.ProductService.entity;

import jakarta.persistence.*;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.enums.Group;

@Entity
@Table(name = "product_classification_score")
public class ProductClassificationScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_сlassification_score_id")
    private int productClassificationScoreId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "humecants")
    private int humectants;

    @Column(name = "emollients")
    private int emollients;

    @Column(name = "proteins")
    private int proteins;

    @Column(name = "drying_alcohols")
    private int dryingAlcohols;

    @Column(name = "heavy_oils")
    private int heavyOils;

    public ProductClassificationScore() {
    }

    public void setHumectants(int humectants) {
        this.humectants = humectants;
    }

    public int getHeavyOils() {
        return heavyOils;
    }

    public int getProductClassificationScoreId() {
        return productClassificationScoreId;
    }

    public void setProductClassificationScoreId(int productClassificationScoreId) {
        this.productClassificationScoreId = productClassificationScoreId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getHumectants() {
        return humectants;
    }

    public void setHumecants(int humecants) {
        this.humectants = humecants;
    }

    public int getEmollients() {
        return emollients;
    }

    public void setEmollients(int emollients) {
        this.emollients = emollients;
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



    public void setHeavyOils(int heavyOils) {
        this.heavyOils = heavyOils;
    }

    public int getValue(Group group) {
        return switch (group) {
            case HUMECTANTS -> getHumectants();
            case EMOLLIENTS -> getEmollients();
            case PROTEINS -> getProteins();
            case DRYING_ALCOHOLS -> getDryingAlcohols();
            case HEAVY_OILS -> getHeavyOils();
        };
    }

    public void increment(Group group) {
        switch (group) {
            case HUMECTANTS -> humectants++;
            case EMOLLIENTS -> emollients++;
            case PROTEINS -> proteins++;
            case DRYING_ALCOHOLS -> dryingAlcohols++;
            case HEAVY_OILS -> heavyOils++;
        }
    }

}


