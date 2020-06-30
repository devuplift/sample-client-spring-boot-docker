package com.example.sample.client.adapter;

import com.example.sample.client.domain.Person;

import java.util.List;

public interface PersonAdapter {
    List<Person> getAllPerson();

    void save(Person person);
}
