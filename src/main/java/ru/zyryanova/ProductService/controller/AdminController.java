package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zyryanova.ProductService.entity.dto.ProductDto;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.repo.PersonRepo;
import ru.zyryanova.ProductService.service.User.AdminManageService;
import ru.zyryanova.ProductService.service.User.PersonService;
import ru.zyryanova.ProductService.service.Product.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminManageService adminManageService;
    private final ProductService productService;


    @Autowired
    public AdminController(AdminManageService adminManageService, ProductService productService) {
        this.adminManageService = adminManageService;
        this.productService = productService;
    }

    @DeleteMapping("/delete/{name}")
    public void deleteProduct(@PathVariable String name){
        adminManageService.deleteProduct(name);
    }
    @PatchMapping("/update/{name}")
    public void updateProduct(@RequestBody ProductDto productDto, @PathVariable String name){
        adminManageService.updateProduct(productDto, name);
    }
    @PostMapping("/create")
    public void createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
    }
    @PatchMapping("/addRole/{email}")
    public void addRole(@PathVariable String email){
        adminManageService.addRole(email);
    }
}
