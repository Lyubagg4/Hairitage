package ru.zyryanova.ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zyryanova.ProductService.entity.ProductClassificationScore;
import ru.zyryanova.ProductService.entity.bd.*;
import ru.zyryanova.ProductService.enums.Group;
import ru.zyryanova.ProductService.repo.HairTypeRepo;
import ru.zyryanova.ProductService.repo.IngredientRepo;
import ru.zyryanova.ProductService.repo.RelevantRangeRepo;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyzeService {
    private final IngredientRepo ingredientRepo;
    private final HairTypeRepo hairTypeRepo;
    private final RelevantRangeRepo relevantRangeRepo;

    @Autowired
    public AnalyzeService(IngredientRepo ingredientRepo, HairTypeRepo hairTypeRepo, RelevantRangeRepo relevantRangeRepo) {
        this.ingredientRepo = ingredientRepo;
        this.hairTypeRepo = hairTypeRepo;
        this.relevantRangeRepo = relevantRangeRepo;
    }

    public ProductClassificationScore analyzeSostav(Product product){
        ProductClassificationScore productClassificationScore = new ProductClassificationScore();
        for(String ingredient: product.getIngredientsList()){
            Ingredient tekIngredient = ingredientRepo.findByIngredientName(ingredient);
            Group groupOfTekIngredient = tekIngredient.getGroup().getGroupName();
            productClassificationScore.increment(groupOfTekIngredient);
        }
        return productClassificationScore;
    }
    public void defineHairType(Product product){
        ProductClassificationScore pcs = analyzeSostav(product);

        //получаю все айдишники типов волос
        List<HairType> hairTypes = hairTypeRepo.findAll();
        List<Integer> hairtypeIds = hairTypes.stream()
                .map(HairType::getHairTypeId)
                .toList();

        List<RelevantRange> listOfRelevantRanges = relevantRangeRepo.findByHairType_HairTypeIdIn(hairtypeIds);
        //в мапе лежат ключ - мапа (группа и relevant_range)
        Map<Integer, EnumMap<Group, RelevantRange>> rules = new HashMap<>();
        for(RelevantRange rr: listOfRelevantRanges){
            int hairTypeId = rr.getHairType().getHairTypeId();
            Group group = rr.getGroup().getGroupName();//это enum
            rules.computeIfAbsent(hairTypeId, k -> new EnumMap<>(Group.class)).put(group, rr);
        }

        for(HairType hairType: hairTypes){
            int hairTypeId = hairType.getHairTypeId();
            EnumMap<Group, RelevantRange> rangeByGroup = rules.getOrDefault(hairTypeId, new EnumMap<>(Group.class));
            if (isOkForHairtype(pcs, rangeByGroup)) {
                product.getProductSuitability().add(hairType);
            }
        }
    }
    public boolean isOkForHairtype(ProductClassificationScore pcs, EnumMap<Group, RelevantRange> rangeByGroup){
        for(RelevantRange rr: rangeByGroup.values()){

            if (rr == null) continue; // если мы его не учли то пропускаем (норм ли это хз)

            Group group = rr.getGroup().getGroupName();
            int valueOfTekGroup = pcs.getValue(group);
            if(valueOfTekGroup>rr.getMaxValue() || valueOfTekGroup<rr.getMinValue()){
                return false;
            }
        }
        return true;
    }

}
