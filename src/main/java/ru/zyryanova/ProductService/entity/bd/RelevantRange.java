package ru.zyryanova.ProductService.entity.bd;


import jakarta.persistence.*;
import ru.zyryanova.ProductService.entity.bd.svyazy.RelevantRangeId;

import java.math.BigDecimal;

@Entity
@Table(name = "relevant_range")
public class RelevantRange {

    @EmbeddedId
    private RelevantRangeId id;

    @MapsId("groupId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id")
    private Groups group;

    @MapsId("hairTypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hair_type_id")
    private HairType hairType;

    @Column(name = "min_value")
    private Integer minValue;

    @Column(name = "max_value")
    private Integer maxValue;

    protected RelevantRange() {}

    public RelevantRangeId getId() {
        return id;
    }

    public void setId(RelevantRangeId id) {
        this.id = id;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public HairType getHairType() {
        return hairType;
    }

    public void setHairType(HairType hairType) {
        this.hairType = hairType;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }
}