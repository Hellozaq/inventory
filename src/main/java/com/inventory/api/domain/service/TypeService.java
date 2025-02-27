package com.inventory.api.domain.service;

import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;


}
