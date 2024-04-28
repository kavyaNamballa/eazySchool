package com.example.registrationlogin.service;

import com.example.registrationlogin.model.Person;
import com.example.registrationlogin.model.Roles;
import com.example.registrationlogin.repos.PersonRepository;
import com.example.registrationlogin.repos.RolesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewUser(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName("STUDENT");
        log.info("----------role: -------------------\n"+role.toString());
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if(person!=null && person.getPersonId()>0){
            isSaved = true;
        }
        return isSaved;
    }
}
