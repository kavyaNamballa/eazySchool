package com.eazySchool.demo.repository;

import com.eazySchool.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {
    Person readByEmail(String email);
}
