package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.zyryanova.ProductService.entity.dto.PersonInfoDto;
import ru.zyryanova.ProductService.entity.dto.ProductDto;
import ru.zyryanova.ProductService.entity.auth.Person;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.service.Selection.SelectionService;
import ru.zyryanova.ProductService.service.User.RegistrationService;
import ru.zyryanova.ProductService.service.User.PersonService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PersonController {
    private final SelectionService selectionService;
    private final ProductRepo productRepo;
    private final RegistrationService registrationService;
    private final PersonService personService;

    @Autowired
    public PersonController(ProductRepo productRepo, SelectionService selectionService, RegistrationService registrationService, PersonService personService) {
        this.productRepo = productRepo;
        this.selectionService = selectionService;
        this.registrationService = registrationService;
        this.personService = personService;
    }

    @PostMapping("/selection")
    public List<ProductDto> selectHairType(@RequestBody List<Integer> answers, Authentication authentication){
        int hairTypeId = selectionService.selectHairType(answers, authentication);
        List<Product> listOfProducts = productRepo.findByProductSuitability_HairTypeId(hairTypeId);
        return selectionService.responseList(listOfProducts);
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
