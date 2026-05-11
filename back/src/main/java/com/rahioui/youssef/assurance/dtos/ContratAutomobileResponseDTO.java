package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.StatutContrat;

import java.time.LocalDate;

public record ContratAutomobileResponseDTO(
    Long id,
    LocalDate dateSouscription,
    StatutContrat statut,
    LocalDate dateValidation,
    Double montantCotisation,
    Integer dureeContrat,
    Double tauxCouverture,
    Long clientId,
    String clientNom,
    String numeroImmatriculation,
    String marqueVehicule,
    String modeleVehicule
) {}
