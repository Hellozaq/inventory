package com.inventory.api.controller;

import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.repository.ModelRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelRepositoy modelRepositoy;

    @GetMapping
    public List<Model> list(){
        return modelRepositoy.findAll();
    }
}
