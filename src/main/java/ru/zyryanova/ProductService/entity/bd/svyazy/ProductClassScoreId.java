package ru.zyryanova.ProductService.entity.bd.svyazy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductClassScoreId implements Serializable {

    @Column(name = "id_product")
    private Integer productId;

    @Column(name = "id_purpose_ing")
    private Integer purposeIngId;

    public ProductClassScoreId() {}

    public ProductClassScoreId(Integer productId, Integer purposeIngId) {
        this.productId = productId;
        this.purposeIngId = purposeIngId;
    }

    public Integer getProductId() { return productId; }
    public Integer getPurposeIngId() { return purposeIngId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductClassScoreId that)) return false;
        return Objects.equals(productId, that.productId)
                && Objects.equals(purposeIngId, that.purposeIngId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, purposeIngId);
    }
}
