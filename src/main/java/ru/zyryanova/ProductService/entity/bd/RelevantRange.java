package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "relevant_range")
public class RelevantRange {

    @EmbeddedId
    private RelevantRangeId id;

    @MapsId("purposeIngId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_purpose_ing", referencedColumnName = "purpose_ing_id")
    private PurposeIng purposeIng;

    @MapsId("hairtypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_hairtype", referencedColumnName = "hairtype_id")
    private Hairtype hairtype;

    @Column(name = "min_value", precision = 38, scale = 10)
    private int minValue;

    @Column(name = "max_value", precision = 38, scale = 10)
    private int maxValue;

    public RelevantRange() {
    }

    public RelevantRangeId getId() {
        return id;
    }

    public void setId(RelevantRangeId id) {
        this.id = id;
    }

    public PurposeIng getPurposeIng() {
        return purposeIng;
    }

    public void setPurposeIng(PurposeIng purposeIng) {
        this.purposeIng = purposeIng;
    }

    public Hairtype getHairtype() {
        return hairtype;
    }

    public void setHairtype(Hairtype hairtype) {
        this.hairtype = hairtype;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}