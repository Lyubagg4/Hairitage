package ru.zyryanova.ProductService.service.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.service.Product.ProductService;

@Service
public class AdminManageService {
    private final ProductRepo productRepo;
    private final ProductService productService;

    @Autowired
    public AdminManageService(ProductRepo productRepo, ProductService productService) {
        this.productRepo = productRepo;
        this.productService = productService;
    }

    public void deleteProduct(int id){
        Product product = productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
    }

    public void updateProduct(ProductDto updateProduct, int id){
        deleteProduct(id);
        productService.createProduct(updateProduct);
    }
}
