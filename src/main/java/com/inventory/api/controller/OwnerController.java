package com.inventory.api.controller;


import com.inventory.api.domain.model.Owner;
import com.inventory.api.domain.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository repository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public List<Owner> list(){
        return repository.findAll();
    }
}
