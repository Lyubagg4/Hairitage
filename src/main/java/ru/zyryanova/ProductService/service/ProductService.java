package ru.zyryanova.ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.entity.bd.ProductType;
import ru.zyryanova.ProductService.entity.bd.RelevantRange;
import ru.zyryanova.ProductService.repo.*;


@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final RelevantRangeRepo relevantRangeRepo;
    private final IngredientRepo ingredientRepo;
    private final ProductTypeRepo productTypeRepo;

    @Autowired
    public ProductService(ProductRepo productRepo, RelevantRangeRepo relevantRangeRepo1, IngredientRepo ingredientRepo, ProductTypeRepo productTypeRepo) {
        this.productRepo = productRepo;
        this.relevantRangeRepo = relevantRangeRepo1;
        this.ingredientRepo = ingredientRepo;
        this.productTypeRepo = productTypeRepo;
    }

    @Transactional
    public Product createProduct(ProductDto productDto) {
        return productRepo.save(convertToProduct(productDto));
    }

    public Product convertToProduct(ProductDto productDto){
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        ProductType productType = productTypeRepo.findByProductTypeName(productDto.getProductTypeName());
        product.setProductType(productType);
        product.setIngredientsList(productDto.getIngredients());
        product.setPrice(productDto.getPrice());
        product.setPicUrl(productDto.getPicUrl());
        return product;
    }
}

