package ru.zyryanova.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.repo.ProductRepo;
import ru.zyryanova.ProductService.service.Selection.SelectionService;
import java.util.List;

@RestController
@RequestMapping("/selection")
public class SelectProductsController {
    private final SelectionService selectionService;
    protected final ProductRepo productRepo;

    @Autowired
    public SelectProductsController(ProductRepo productRepo, SelectionService selectionService) {
        this.productRepo = productRepo;
        this.selectionService = selectionService;
    }

    @PostMapping()
    public List<ProductDto> selectHairType(@RequestBody List<Integer> answers){
        System.out.println(answers);
        int hairTypeId = selectionService.selectHairType(answers);
        List<Product> listOfProducts = productRepo.findByProductSuitability_HairTypeId(hairTypeId);
        return selectionService.responseList(listOfProducts);
    }
}
