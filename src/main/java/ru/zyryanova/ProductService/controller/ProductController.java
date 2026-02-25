package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.service.AnalyzeService;
import ru.zyryanova.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final AnalyzeService analyzeService;

    @Autowired
    public ProductController(ProductService productService, AnalyzeService analyzeService) {
        this.productService = productService;
        this.analyzeService = analyzeService;
    }

    @PostMapping("/new")
    public void createProduct(@RequestBody ProductDto productDto){
        Product product = productService.createProduct(productDto);
        analyzeService.defineHairType(product);

    }

    Product convertToProduct(ProductDto productDto){
        Product product = new Product();
        return product;
    }
}
