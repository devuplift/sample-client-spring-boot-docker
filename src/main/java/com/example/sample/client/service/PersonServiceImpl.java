package com.example.sample.client.service;

import com.example.sample.client.adapter.PersonAdapterImpl;
import com.example.sample.client.domain.Person;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonAdapterImpl personAdapterImpl;

    public PersonServiceImpl(PersonAdapterImpl personAdapterImpl) {
        this.personAdapterImpl = personAdapterImpl;
    }

    @Override
    public void savePerson(Person person) {
        personAdapterImpl.save(person);
    }

    @Override
    public List<Person> allPerson() {
        return personAdapterImpl.getAllPerson();
    }
}
