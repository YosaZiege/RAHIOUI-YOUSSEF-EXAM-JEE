package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.NiveauCouverture;
import com.rahioui.youssef.assurance.enums.StatutContrat;

import java.time.LocalDate;

public record ContratSanteResponseDTO(
    Long id,
    LocalDate dateSouscription,
    StatutContrat statut,
    LocalDate dateValidation,
    Double montantCotisation,
    Integer dureeContrat,
    Double tauxCouverture,
    Long clientId,
    String clientNom,
    NiveauCouverture niveauCouverture,
    Integer nombrePersonnesCouvertes
) {}
