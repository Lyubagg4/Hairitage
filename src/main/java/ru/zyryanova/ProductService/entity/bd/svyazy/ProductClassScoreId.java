package ru.zyryanova.ProductService.entity.bd.svyazy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductClassScoreId implements Serializable {

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "group_id")
    private Integer groupId;

    public ProductClassScoreId() {}

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductClassScoreId that)) return false;
        return Objects.equals(productId, that.productId)
                && Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, groupId);
    }
}
