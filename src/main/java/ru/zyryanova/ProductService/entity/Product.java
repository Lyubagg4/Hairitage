//package ru.zyryanova.ProductService.entity;
//
//import jakarta.persistence.*;
//import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
//
//import java.util.List;
//
//@Entity
//@Table(name = "product")
//public class Product{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int product_id;
//
////    @Column(name = "brand")
////    private String brand;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "json_of_ingredient")
//    private JacksonProperties.Json jsonOfIngredients;
//
//    @Column(name = "price")
//    private String price;
//
//    @Column(name = "product_type_id")
//    private int productTypeId;
//
//    public Product() {
//    }
//
//    public int getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(int product_id) {
//        this.product_id = product_id;
//    }
//
////    public String getBrand() {
////        return brand;
////    }
////
////    public void setBrand(String brand) {
////        this.brand = brand;
////    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public JacksonProperties.Json getJsonOfIngredients() {
//        return jsonOfIngredients;
//    }
//
//    public void setJsonOfIngredients(JacksonProperties.Json jsonOfIngredients) {
//        this.jsonOfIngredients = jsonOfIngredients;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public int getProductTypeId() {
//        return productTypeId;
//    }
//
//    public void setProductTypeId(int productTypeId) {
//        this.productTypeId = productTypeId;
//    }
//}
//
//
