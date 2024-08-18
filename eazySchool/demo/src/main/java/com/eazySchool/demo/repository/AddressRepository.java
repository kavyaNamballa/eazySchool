package com.eazySchool.demo.repository;

import com.eazySchool.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Person,Integer> {

}
