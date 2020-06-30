package com.example.sample.client.adapter;

import com.example.sample.client.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonAdapterImpl implements PersonAdapter {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${person.api.base.url}")
    private String personAPIBaseUrl;

    @Value("${person.api}")
    private String personURI;

    @Value("${persons.api}")
    private String allPersonsURI;

    public PersonAdapterImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Person> getAllPerson() {
        ResponseEntity<List<Person>> persons =
                restTemplate.exchange(personAPIBaseUrl+allPersonsURI,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {});
        return persons.getBody();
    }

    @Override
    public void save(Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Person> entity = new HttpEntity<>(person, headers);
        restTemplate.exchange(personAPIBaseUrl+personURI, HttpMethod.POST, entity, String.class);
    }
}
