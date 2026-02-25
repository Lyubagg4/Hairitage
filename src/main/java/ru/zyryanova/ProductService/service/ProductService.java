package ru.zyryanova.ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zyryanova.ProductService.entity.ProductClassificationScore;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Ingredient;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.entity.bd.ProductType;
import ru.zyryanova.ProductService.entity.bd.RelevantRange;
import ru.zyryanova.ProductService.enums.Groups;
import ru.zyryanova.ProductService.repo.*;

import javax.swing.*;


@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final RelevantRangeRepo relevantRangeRepo;
    private final ProductClassScoreRepo productClassScoreRepo;
    private final IngredientRepo ingredientRepo;
    private final ProductTypeRepo productTypeRepo;

    @Autowired
    public ProductService(ProductRepo productRepo, RelevantRange relevantRangeRepo, RelevantRangeRepo relevantRangeRepo1, ProductClassScoreRepo productClassScoreRepo, IngredientRepo ingredientRepo, ProductTypeRepo productTypeRepo) {
        this.productRepo = productRepo;
        this.relevantRangeRepo = relevantRangeRepo1;
        this.productClassScoreRepo = productClassScoreRepo;
        this.ingredientRepo = ingredientRepo;
        this.productTypeRepo = productTypeRepo;
    }




    public Product createProduct(ProductDto productDto) {
        return productRepo.save(convertToProduct(productDto));
    }

    public Product convertToProduct(ProductDto productDto){
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        ProductType productType = productTypeRepo.findByProductTypeName(productDto.getProductTypeName());
        product.setProductTypeId(productType.getTypeProductId());
        product.setIngredientsList(productDto.getIngredients());
        product.setPrice(productDto.getPrice());
        product.setPicUrl(productDto.getPicUrl());
        return product;
    }
}

