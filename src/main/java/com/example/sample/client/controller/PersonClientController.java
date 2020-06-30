package com.example.sample.client.controller;

import com.example.sample.client.domain.Person;
import com.example.sample.client.service.PersonServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PersonClientController {

    private PersonServiceImpl personServiceImpl;

    public PersonClientController(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @PostMapping(value = "/client/person", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void savePerson(@RequestBody Person person) {
         personServiceImpl.savePerson(person);
    }

    @GetMapping(value = "/client/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> allPerson() {
        return personServiceImpl.allPerson();
    }

}
