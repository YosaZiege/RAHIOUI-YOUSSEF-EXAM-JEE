package com.rahioui.youssef.assurance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rahioui.youssef.assurance.enums.StatutContrat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrats_assurance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_contrat", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public abstract class ContratAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateSouscription;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    private LocalDate dateValidation;

    private Double montantCotisation;

    private Integer dureeContrat;

    private Double tauxCouverture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @OneToMany(mappedBy = "contrat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Paiement> paiements = new ArrayList<>();
}
