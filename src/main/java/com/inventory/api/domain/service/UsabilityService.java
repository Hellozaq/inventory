package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.model.Usability;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.UsabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsabilityService {

    @Autowired
    private UsabilityRepository usabilityRepository;

    @Autowired
    private ProductRepository productRepository;

    public Usability addUsability(Usability usability) {
        return usabilityRepository.save(usability);
    }

    public void removeUsability(Long id) {
        Optional<Usability> usability = usabilityRepository.findById(id);
        if (productRepository.existsByUsability(usability.get())) {
            throw new RuntimeException("Não é possível excluir. Existem produtos associados a este tipo.");
        }else{
            usabilityRepository.delete(usability.get());
        }

    }
}
