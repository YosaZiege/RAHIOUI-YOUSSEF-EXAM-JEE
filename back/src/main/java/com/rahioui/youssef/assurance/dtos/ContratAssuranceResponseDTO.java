package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.StatutContrat;

import java.time.LocalDate;

public record ContratAssuranceResponseDTO(
    Long id,
    String typeContrat,
    LocalDate dateSouscription,
    StatutContrat statut,
    LocalDate dateValidation,
    Double montantCotisation,
    Integer dureeContrat,
    Double tauxCouverture,
    Long clientId,
    String clientNom
) {}
