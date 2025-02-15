package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Permission;
import com.inventory.api.domain.model.Person;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.PermissionRepository;
import com.inventory.api.domain.repository.PersonRepository;
import com.inventory.api.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person userAdd(UserDTO userDTO) {
        Person person = new Person();
        person.setId(userDTO.getId());
        person.setName(userDTO.getName());
        person.setMail(userDTO.getMail());
        person.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Criptografa a senha

        // Buscar e associar permissões
        List<Permission> permissoes = new ArrayList<>(permissionRepository.findAllById(userDTO.getPermissionsIds()));
        person.setPermission(permissoes);


        return personRepository.save(person);
    }
}
