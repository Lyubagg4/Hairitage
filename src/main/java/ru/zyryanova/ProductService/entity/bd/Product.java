package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_product", referencedColumnName = "type_product_id")
    private TypeProduct typeProduct;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "price_category")
    private String priceCategory;

    // УПРОЩЁННО: text[] как одна строка (например JSON/CSV)
    @Column(name = "ingredients_list", columnDefinition = "text[]")
    private String ingredientsList;

    @ManyToMany
    @JoinTable(
            name = "product_suitability",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "id_hairtype", referencedColumnName = "hairtype_id")
    )
    private Set<Hairtype> suitableHairtypes = new HashSet<>();

    public Product() {
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }

    public String getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(String ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public Set<Hairtype> getSuitableHairtypes() {
        return suitableHairtypes;
    }

    public void setSuitableHairtypes(Set<Hairtype> suitableHairtypes) {
        this.suitableHairtypes = suitableHairtypes;
    }
}
