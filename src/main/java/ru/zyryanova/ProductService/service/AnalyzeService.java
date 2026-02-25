package ru.zyryanova.ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zyryanova.ProductService.entity.ProductClassificationScore;
import ru.zyryanova.ProductService.entity.bd.Ingredient;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.enums.Groups;
import ru.zyryanova.ProductService.repo.IngredientRepo;

@Service
public class AnalyzeService {
    private final IngredientRepo ingredientRepo;

    @Autowired
    public AnalyzeService(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    public ProductClassificationScore analyzeSostav(Product product){
        ProductClassificationScore productClassificationScore = new ProductClassificationScore();
        for(String ingredient: product.getIngredientsList()){
            Ingredient tekIngredient = ingredientRepo.findByName(ingredient);
            Groups groupOfTekIngredient = tekIngredient.getGroupId().getGroupName();
            productClassificationScore.increment(groupOfTekIngredient);
        }
        return productClassificationScore;
    }
    public void defineHairType(Product product){
        ProductClassificationScore productClassificationScore =  analyzeSostav(product);



    }
}
