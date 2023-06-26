package com.example.rmbe.repository;

import com.example.rmbe.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepo extends JpaRepository<Person, Integer> {
    List<Person> findAll();
    Person findFirstById( int id);
}
