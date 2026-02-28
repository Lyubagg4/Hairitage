package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.admin.Admin;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.service.Admin.AdminManageService;
import ru.zyryanova.ProductService.service.Admin.RegistrationService;
import ru.zyryanova.ProductService.service.Product.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final RegistrationService registrationService;
    private final AdminManageService adminManageService;
    private final ProductService productService;


    @Autowired
    public AdminController(RegistrationService registrationService, AdminManageService adminManageService, ProductRepo productRepo, ProductService productService) {
        this.registrationService = registrationService;
        this.adminManageService = adminManageService;
        this.productService = productService;
    }
    @PostMapping("/registration")
    public void registration(@RequestBody Admin admin){
        registrationService.register(admin);
    }
    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        adminManageService.deleteProduct(id);
    }
    @PatchMapping("/update/{id}")
    public void updateProduct(@RequestBody ProductDto productDto, @PathVariable int id){
        adminManageService.updateProduct(productDto, id);
    }
    @PostMapping("/create")
    public void createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
    }

}
