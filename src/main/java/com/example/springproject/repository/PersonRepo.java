package com.example.springproject.repository;

import com.example.springproject.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person,Long> {
    List<Person> findByEmail(String email);
}
