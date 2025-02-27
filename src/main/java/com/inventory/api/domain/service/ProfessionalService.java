package com.inventory.api.domain.service;



import com.inventory.api.domain.model.Professional;

import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProductRepository productRepository;

    public Professional addProfessional(Professional professional) {
        return professionalRepository.save(professional);
    }

    public void removeProfessional(Long id) {
        Optional<Professional> professional = professionalRepository.findById(id);
        if (productRepository.existsByProfessional(professional.get())) {
            throw new RuntimeException("Não é possível excluir. Existem produtos associados a este id.");
        }else{
            professionalRepository.delete(professional.get());
        }

    }
}
