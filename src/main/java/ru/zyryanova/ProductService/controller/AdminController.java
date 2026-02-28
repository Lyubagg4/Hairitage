package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zyryanova.ProductService.entity.admin.Admin;
import ru.zyryanova.ProductService.service.Admin.RegistrationService;

@RestController
@RequestMapping("/registration")
public class AdminController {
    private final RegistrationService registrationService;

    @Autowired
    public AdminController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping()
    public void registration(@RequestBody Admin admin){
        registrationService.register(admin);
    }
}
