package com.inventory.api.domain.repository;

import com.inventory.api.domain.model.*;
import com.inventory.api.domain.repository.filter.ProductFilter;
import com.inventory.api.domain.repository.product.ProductRepositoryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryQuery {
    Page<Product> findByEstablishmentId(Long establishmentId, Pageable pageable);

    boolean existsByOwner(Owner owner);
    boolean existsByProfessional(Professional professional);
    boolean existsByUsability(Usability usability);
    boolean existsByModel(Model model);
}
