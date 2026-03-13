package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.zyryanova.ProductService.entity.dto.PersonInfoDto;
import ru.zyryanova.ProductService.entity.dto.ProductDto;
import ru.zyryanova.ProductService.entity.auth.Person;
import ru.zyryanova.ProductService.service.Product.ProductService;
import ru.zyryanova.ProductService.service.Selection.SelectionService;
import ru.zyryanova.ProductService.service.User.RegistrationService;
import ru.zyryanova.ProductService.service.User.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final SelectionService selectionService;
    private final ProductService productService;
    private final RegistrationService registrationService;
    private final PersonService personService;

    @Autowired
    public PersonController(SelectionService selectionService, ProductService productService, RegistrationService registrationService, PersonService personService) {
        this.productService = productService;
        this.selectionService = selectionService;
        this.registrationService = registrationService;
        this.personService = personService;
    }
    // это подборка сразу на основе определения типа волос
    @PostMapping("/selection")
    public List<ProductDto> selectHairTypeAndProducts(@RequestBody List<Integer> answers, Authentication authentication){
        int hairTypeId = selectionService.selectHairType(answers, authentication);
        return productService.listOfProducts(hairTypeId);
    }
    // это подборка продуктов для аутентифицированного пользователя
    @GetMapping("/selection/auth")
    public List<ProductDto> selectProductsOfAuthPerson(Authentication authentication){
        int hairTypeId = personService.defineHairTypeOfAuthPerson(authentication).getHairTypeId();
        return productService.listOfProducts(hairTypeId);
    }
    @PostMapping("/registration")
    public void registration(@RequestBody Person person){
        registrationService.register(person);
    }

    @GetMapping("/accountInfo")
    public ResponseEntity<PersonInfoDto> accountInfo(Authentication authentication) {
        return personService.showInfo(authentication.getName());
    }
}
