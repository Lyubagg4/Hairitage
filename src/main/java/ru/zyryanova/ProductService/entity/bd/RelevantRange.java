package ru.zyryanova.ProductService.entity.bd;


import jakarta.persistence.*;
import ru.zyryanova.ProductService.entity.bd.svyazy.RelevantRangeId;

import java.math.BigDecimal;

@Entity
@Table(name = "relevant_range")
public class RelevantRange {

    @EmbeddedId
    private RelevantRangeId id;

    @MapsId("purposeIngId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_purpose_ing", referencedColumnName = "purpose_ing_id")
    private Group purposeIng;

    @MapsId("hairtypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_hairtype", referencedColumnName = "hairtype_id")
    private Hairtype hairtype;

    @Column(name = "min_value")
    private BigDecimal minValue;

    @Column(name = "max_value")
    private BigDecimal maxValue;

    protected RelevantRange() {}


    public RelevantRangeId getId() { return id; }
    public Group getPurposeIng() { return purposeIng; }
    public Hairtype getHairtype() { return hairtype; }
    public BigDecimal getMinValue() { return minValue; }
    public BigDecimal getMaxValue() { return maxValue; }

    public void setMinValue(BigDecimal minValue) { this.minValue = minValue; }
    public void setMaxValue(BigDecimal maxValue) { this.maxValue = maxValue; }
}