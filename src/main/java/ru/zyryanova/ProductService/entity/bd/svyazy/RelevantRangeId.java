package ru.zyryanova.ProductService.entity.bd.svyazy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelevantRangeId implements Serializable {

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "hair_type_id")
    private Integer hairTypeId;

    public RelevantRangeId() {}

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getHairTypeId() {
        return hairTypeId;
    }

    public void setHairTypeId(Integer hairTypeId) {
        this.hairTypeId = hairTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelevantRangeId that)) return false;
        return Objects.equals(groupId, that.getGroupId())
                && Objects.equals(hairTypeId, that.hairTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, hairTypeId);
    }
}