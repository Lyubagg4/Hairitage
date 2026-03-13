package ru.zyryanova.ProductService.service.Selection;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.auth.Person;
import ru.zyryanova.ProductService.entity.bd.HairType;
import ru.zyryanova.ProductService.finder.Finder;
import ru.zyryanova.ProductService.repo.HairTypeRepo;
import ru.zyryanova.ProductService.repo.PersonRepo;
import ru.zyryanova.ProductService.repo.ProductRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectionService {
    private final PersonRepo personRepo;
    private final HairTypeRepo hairTypeRepo;
    private final Finder finder;

    public SelectionService(PersonRepo personRepo, HairTypeRepo hairTypeRepo, Finder finder) {
        this.personRepo = personRepo;
        this.hairTypeRepo = hairTypeRepo;
        this.finder = finder;
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
        if (authentication!=null && !(authentication instanceof AnonymousAuthenticationToken)) {
            Person person = finder.findPersonOrThrow(authentication.getName());
            HairType hairType = hairTypeRepo.findById(resType).orElseThrow();
            person.setHairType(hairType);
            personRepo.save(person);
        }
        return resType;
    }



}
