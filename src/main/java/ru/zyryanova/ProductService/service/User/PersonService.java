package ru.zyryanova.ProductService.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.dto.PersonInfoDto;
import ru.zyryanova.ProductService.entity.auth.Person;
import ru.zyryanova.ProductService.enums.Role;
import ru.zyryanova.ProductService.repo.PersonRepo;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }


    public ResponseEntity<PersonInfoDto> showInfo(String username){
        Person person = personRepo.findByEmail(username);
        PersonInfoDto personInfoDto = new PersonInfoDto(person.getUsername(), person.getEmail(), person.getHairType().getHairTypeId());
        return ResponseEntity.ok(personInfoDto);
    }

    @Transactional
    public void addRole(int id){
        personRepo.findById(id).orElseThrow().setRole(Role.ADMIN);
    }
}
