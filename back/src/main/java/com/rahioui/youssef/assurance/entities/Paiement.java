package com.rahioui.youssef.assurance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rahioui.youssef.assurance.enums.TypePaiement;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "paiements")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Double montant;

    @Enumerated(EnumType.STRING)
    private TypePaiement type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrat_id")
    @JsonIgnore
    private ContratAssurance contrat;
}
