package ru.zyryanova.ProductService.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.bd.HairType;
import ru.zyryanova.ProductService.entity.dto.PersonInfoDto;
import ru.zyryanova.ProductService.entity.auth.Person;
import ru.zyryanova.ProductService.enums.Role;
import ru.zyryanova.ProductService.finder.Finder;
import ru.zyryanova.ProductService.globalHandler.exception.PersonNotFoundException;
import ru.zyryanova.ProductService.repo.PersonRepo;

@Service
public class PersonService {
    private final PersonRepo personRepo;
    private final Finder finder;

    @Autowired
    public PersonService(PersonRepo personRepo, Finder finder) {
        this.personRepo = personRepo;
        this.finder = finder;
    }


    public ResponseEntity<PersonInfoDto> showInfo(String username){
        Person person = finder.findPersonOrThrow(username);
        Integer hairTypeId = person.getHairType() != null
                ? person.getHairType().getHairTypeId()
                : null;

        PersonInfoDto personInfoDto =
                new PersonInfoDto(person.getUsername(), person.getEmail(), hairTypeId);

        return ResponseEntity.ok(personInfoDto);
    }

    @Transactional
    public void addRole(int id){
       finder.findPersonOrThrow(id).setRole(Role.ADMIN);
    }

    public HairType defineHairTypeOfAuthPerson(Authentication authentication){
        Person person = finder.findPersonOrThrow(authentication.getName());
        if(person.getHairType()==null){
            throw new IllegalStateException("Тип неопределен");
        }
        return person.getHairType();
    }


}
