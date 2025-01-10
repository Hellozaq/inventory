package com.inventory.api.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Product {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dpurchase = LocalDate.now();

    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;

    @JoinColumn(name = "id_owner")
    @ManyToOne()
    private Owner owner;

    @JoinColumn(name = "id_model")
    @ManyToOne()
    private Model model;

    @JoinColumn(name = "id_usability")
    @ManyToOne()
    private Usability usability;

    @JoinColumn(name = "id_professional")
    @ManyToOne()
    private Professional professional;

    @JoinColumn(name = "id_establishment")
    @ManyToOne()
    private Establishment establishment;


}
