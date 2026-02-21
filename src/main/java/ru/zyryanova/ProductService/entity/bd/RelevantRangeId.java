package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelevantRangeId implements Serializable {

    @Column(name = "id_purpose_ing")
    private Integer purposeIngId;

    @Column(name = "id_hairtype")
    private Integer hairtypeId;

    public RelevantRangeId() {}

    public Integer getPurposeIngId() {
        return purposeIngId;
    }

    public void setPurposeIngId(Integer purposeIngId) {
        this.purposeIngId = purposeIngId;
    }

    public Integer getHairtypeId() {
        return hairtypeId;
    }

    public void setHairtypeId(Integer hairtypeId) {
        this.hairtypeId = hairtypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelevantRangeId that)) return false;
        return Objects.equals(purposeIngId, that.purposeIngId)
                && Objects.equals(hairtypeId, that.hairtypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purposeIngId, hairtypeId);
    }

    // getters/setters
}
