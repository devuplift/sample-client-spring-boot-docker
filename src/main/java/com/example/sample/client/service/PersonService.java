package com.example.sample.client.service;

import com.example.sample.client.domain.Person;
import java.util.List;

public interface PersonService {

    void savePerson(Person person);
    List<Person> allPerson();
}
