package ru.zyryanova.ProductService.service.Selection;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.dto.ProductDto;
import ru.zyryanova.ProductService.entity.auth.Person;
import ru.zyryanova.ProductService.entity.bd.HairType;
import ru.zyryanova.ProductService.entity.bd.Product;
import ru.zyryanova.ProductService.repo.HairTypeRepo;
import ru.zyryanova.ProductService.repo.PersonRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectionService {
    private final PersonRepo personRepo;
    private final HairTypeRepo hairTypeRepo;

    public SelectionService(PersonRepo personRepo, HairTypeRepo hairTypeRepo) {
        this.personRepo = personRepo;
        this.hairTypeRepo = hairTypeRepo;
    }
    @Transactional
    public int selectHairType(List<Integer> answers, Authentication authentication){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int answer: answers){
            countMap.put(answer, countMap.getOrDefault(answer,0)+1);
        }
        int resType = 0;
        int resValue = 0;
        for(int key: countMap.keySet()){
            int tekValue = countMap.get(key);
            if(tekValue>resValue){
                resValue = tekValue;
                resType = key;
            }
        }
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Person person = personRepo.findByEmail(authentication.getName());
            HairType hairType = hairTypeRepo.findById(resType).orElseThrow();
            person.setHairType(hairType);
            personRepo.save(person);
        }
        return resType;
    }
    @Transactional
    public List<ProductDto> responseList(List<Product> listOfProducts){
        return listOfProducts.stream().map(p ->{
            ProductDto dto = new ProductDto();
            dto.setProductName(p.getProductName());
            dto.setProductTypeName(p.getProductType().getProductTypeName());
            dto.setIngredients(p.getIngredientsList());
            dto.setPicUrl(p.getPicUrl());
            dto.setPrice(p.getPrice());
            return dto;}
        ).toList();
    }
}
