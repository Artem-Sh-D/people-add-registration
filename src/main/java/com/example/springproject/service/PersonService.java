package com.example.springproject.service;

import com.example.springproject.entity.Person;
import com.example.springproject.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public void personSaveDate(String email, String password) {
        List<Person> persons = personRepo.findByEmail(email);
        if(persons.isEmpty()){
            Person person = new Person(email,password);
            personRepo.save(person);
        } else {
            throw new IllegalArgumentException("Такой уже существует!");
        }

    }
    public Iterable<Person> getAllPerson() {
        return personRepo.findAll();
    }
}
