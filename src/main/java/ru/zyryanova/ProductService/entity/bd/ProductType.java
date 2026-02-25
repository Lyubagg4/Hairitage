package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;

@Entity
@Table(name = "type_product")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_product_id")
    private Integer typeProductId;

    @Column(name = "name", nullable = false, unique = true)
    private String productTypeName;

    public ProductType() {
    }

    public Integer getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(Integer typeProductId) {
        this.typeProductId = typeProductId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}