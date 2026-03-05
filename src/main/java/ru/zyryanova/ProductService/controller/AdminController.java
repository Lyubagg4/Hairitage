package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zyryanova.ProductService.entity.dto.ProductDto;
import ru.zyryanova.ProductService.enums.Role;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.repo.PersonRepo;
import ru.zyryanova.ProductService.service.User.AdminManageService;
import ru.zyryanova.ProductService.service.User.PersonService;
import ru.zyryanova.ProductService.service.User.RegistrationService;
import ru.zyryanova.ProductService.service.Product.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final PersonService personService;
    private final AdminManageService adminManageService;
    private final ProductService productService;
    private final PersonRepo personRepo;


    @Autowired
    public AdminController(AdminManageService adminManageService, ProductRepo productRepo, PersonService personService, ProductService productService, PersonRepo personRepo) {
        this.adminManageService = adminManageService;
        this.personService = personService;
        this.productService = productService;
        this.personRepo = personRepo;
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
    @PatchMapping("/{id}/addRole")
    public void addRole(@PathVariable int id){
        adminManageService.addRole(id);
    }
}
