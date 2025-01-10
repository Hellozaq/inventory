package com.inventory.api.controller;

import com.inventory.api.domain.model.Usability;
import com.inventory.api.domain.repository.UsabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/usabilities")
public class UsabilityController {

    @Autowired
    private UsabilityRepository repository;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<Usability> list(){
        return repository.findAll();
    }

}
