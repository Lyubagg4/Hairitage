package ru.zyryanova.ProductService.service.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.ProductClassificationScore;
import ru.zyryanova.ProductService.entity.bd.*;
import ru.zyryanova.ProductService.enums.Group;
import ru.zyryanova.ProductService.repo.*;
import ru.zyryanova.ProductService.service.RulesCacheService;
import ru.zyryanova.ProductService.tools.Range;

import java.util.EnumMap;
import java.util.Map;

@Service
public class AnalyzeService {
    private final IngredientRepo ingredientRepo;
    private final ProductRepo productRepo;
    private final HairTypeRepo hairTypeRepo;
    private final RelevantRangeRepo relevantRangeRepo;
    private final ProductClassificationScoreRepo productClassificationScoreRepo;
    private final RulesCacheService rulesCacheService;


    @Autowired
    public AnalyzeService(IngredientRepo ingredientRepo, ProductRepo productRepo, HairTypeRepo hairTypeRepo, RelevantRangeRepo relevantRangeRepo, ProductClassificationScoreRepo productClassificationScoreRepo, RulesCacheService rulesCacheService) {
        this.ingredientRepo = ingredientRepo;
        this.productRepo = productRepo;
        this.hairTypeRepo = hairTypeRepo;
        this.relevantRangeRepo = relevantRangeRepo;
        this.productClassificationScoreRepo = productClassificationScoreRepo;
        this.rulesCacheService = rulesCacheService;
    }

    public ProductClassificationScore analyzeSostav(Product product){
        ProductClassificationScore productClassificationScore = new ProductClassificationScore();
        productClassificationScore.setProduct(product);
        for(String ingredient: product.getIngredientsList()){
            Ingredient tekIngredient = ingredientRepo.findByIngredientName(ingredient);
            Group groupOfTekIngredient = tekIngredient.getGroup().getGroupName();
            productClassificationScore.increment(groupOfTekIngredient);
        }
        return productClassificationScore;
    }
    @Transactional
    public void defineHairType(int productId){
        Product product = productRepo.findById(productId).orElseThrow();
        Map<Integer, EnumMap<Group, Range>> rules = rulesCacheService.getRules();
        ProductClassificationScore pcs = analyzeSostav(product);
        for(int hairTypeId: rules.keySet()){
            EnumMap<Group, Range> rangeByGroup = rules.getOrDefault(hairTypeId, new EnumMap<>(Group.class));
            if (isOkForHairType(pcs, rangeByGroup)) {
                HairType hairType = hairTypeRepo.findById(hairTypeId).orElseThrow();
                product.getProductSuitability().add(hairType);
            }
        }
        productRepo.save(product);
        productClassificationScoreRepo.save(pcs);
    }
    public boolean isOkForHairType(ProductClassificationScore pcs,
                                   EnumMap<Group, Range> rangeByGroup) {

        for (Map.Entry<Group, Range> e : rangeByGroup.entrySet()) {
            Group group = e.getKey();
            Range rr = e.getValue();
            if (rr == null) continue;

            int value = pcs.getValue(group);

            if (value > rr.getMax() || value < rr.getMin()) {
                return false;
            }
        }
        return true;
    }

}
