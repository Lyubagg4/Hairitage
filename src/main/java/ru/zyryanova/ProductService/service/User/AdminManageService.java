package ru.zyryanova.ProductService.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.dto.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.enums.Role;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.repo.PersonRepo;
import ru.zyryanova.ProductService.service.Product.ProductService;

@Service
public class AdminManageService {
    private final ProductRepo productRepo;
    private final ProductService productService;
    private final PersonRepo personRepo;

    @Autowired
    public AdminManageService(ProductRepo productRepo, ProductService productService, PersonRepo personRepo) {
        this.productRepo = productRepo;
        this.productService = productService;
        this.personRepo = personRepo;
    }

    public void deleteProduct(int id){
        Product product = productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
    }

    public void updateProduct(ProductDto updateProduct, int id){
        deleteProduct(id);
        productService.createProduct(updateProduct);
    }
    @Transactional
    public void addRole(int id){
        personRepo.findById(id).orElseThrow().setRole(Role.ADMIN);
    }
}
