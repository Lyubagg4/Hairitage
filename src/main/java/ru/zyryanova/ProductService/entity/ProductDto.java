package ru.zyryanova.ProductService.entity;

import java.util.List;

public class ProductDto{
    private int productDtoId;
//    private String brand;
    private String name;
    private List<String> ingredients;
    private String price;

    public ProductDto() {
    }


    public int getProductDtoId() {
        return productDtoId;
    }

    public void setProductDtoId(int productDtoId) {
        this.productDtoId = productDtoId;
    }

//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


