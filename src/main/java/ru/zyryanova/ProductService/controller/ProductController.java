package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public void createProduct(ProductDto productDto){
        productService.defineHairType(convertToProduct(productDto));

    }

    Product convertToProduct(ProductDto productDto){
        Product product = new Product();
        return product;
    }
}
