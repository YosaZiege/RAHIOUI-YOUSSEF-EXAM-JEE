package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.StatutContrat;
import com.rahioui.youssef.assurance.enums.TypeLogement;

import java.time.LocalDate;

public record ContratHabitationResponseDTO(
    Long id,
    LocalDate dateSouscription,
    StatutContrat statut,
    LocalDate dateValidation,
    Double montantCotisation,
    Integer dureeContrat,
    Double tauxCouverture,
    Long clientId,
    String clientNom,
    TypeLogement typeLogement,
    String adresse,
    Double superficie
) {}
