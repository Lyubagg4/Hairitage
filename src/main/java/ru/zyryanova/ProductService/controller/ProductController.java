package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.service.Product.AnalyzeService;
import ru.zyryanova.ProductService.service.Product.ProductService;
import ru.zyryanova.ProductService.service.RulesCacheService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final AnalyzeService analyzeService;
    private final RulesCacheService rulesCacheService;

    @Autowired
    public ProductController(ProductService productService, AnalyzeService analyzeService, RulesCacheService rulesCacheService) {
        this.productService = productService;
        this.analyzeService = analyzeService;
        this.rulesCacheService = rulesCacheService;
    }

    @PostMapping("/addProducts")
    public void createProduct(@RequestBody List<ProductDto> productDto){
        rulesCacheService.reload();
        for(ProductDto tekDto: productDto){
            int productId = productService.createProduct(tekDto).getProductId();
            analyzeService.defineHairType(productId);
        }
    }
}
