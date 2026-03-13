package ru.zyryanova.ProductService.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.dto.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.enums.Role;
import ru.zyryanova.ProductService.finder.Finder;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.repo.PersonRepo;
import ru.zyryanova.ProductService.service.Product.ProductService;

@Service
public class AdminManageService {
    private final ProductRepo productRepo;
    private final ProductService productService;
    private final PersonRepo personRepo;
    private final Finder finder;

    @Autowired
    public AdminManageService(ProductRepo productRepo, ProductService productService, PersonRepo personRepo, Finder finder) {
        this.productRepo = productRepo;
        this.productService = productService;
        this.personRepo = personRepo;
        this.finder = finder;
    }

    public void deleteProduct(String name){
        Product product = finder.findProductOrThrow(name);
        productRepo.delete(product);
    }

    public void updateProduct(ProductDto updateProduct, String productName){
        deleteProduct(productName);
        productService.createProduct(updateProduct);
    }
    @Transactional
    public void addRole(String email){
        finder.findPersonOrThrow(email).setRole(Role.ADMIN);
    }
}
