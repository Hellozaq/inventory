package com.inventory.api.controller;

import com.inventory.api.domain.model.Professional;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

    @Autowired
    ProfessionalRepository repository;

    @GetMapping
    public List<Professional> list(){
        return repository.findAll();
    }

}
