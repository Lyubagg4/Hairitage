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
    @JoinColumn(name = "group_id", referencedColumnName = "groupId")
    private Groups group;

    @MapsId("hairTypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hair_type_id", referencedColumnName = "hairTypeId")
    private HairType hairtype;

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

    public HairType getHairtype() {
        return hairtype;
    }

    public void setHairtype(HairType hairtype) {
        this.hairtype = hairtype;
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