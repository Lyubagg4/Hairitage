package ru.zyryanova.ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.zyryanova.ProductService.entity.ProductClassificationScore;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.repo.ProductRepo;

import java.util.Comparator;

public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductClassificationScore analyzeSostav(Product product){
        ProductClassificationScore productClassificationScore = new ProductClassificationScore();
        productClassificationScore.setProductId(product.getProductId());
        for(){
            //логика по анализу коэффы и тд
        }
        return productClassificationScore;
    }
    public void defineHairType(Product product){
       ProductClassificationScore productClassificationScore =  analyzeSostav(product);

    }
}
// сущности добавить
// добавить еще
