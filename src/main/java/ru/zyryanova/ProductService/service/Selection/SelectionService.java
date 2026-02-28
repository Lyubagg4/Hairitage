package ru.zyryanova.ProductService.service.Selection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.ProductDto;
import ru.zyryanova.ProductService.entity.bd.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectionService {
    public int selectHairType(List<Integer> answers){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int answer: answers){
            countMap.put(answer, countMap.getOrDefault(answer,0)+1);
        }
        int resType = 0;
        for(int key: countMap.keySet()){
            int tekValue = countMap.get(key);
            if(tekValue>resType){
                resType = key;
            }
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
