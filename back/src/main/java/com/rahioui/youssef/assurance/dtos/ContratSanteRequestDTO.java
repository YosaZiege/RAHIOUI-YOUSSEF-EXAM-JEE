package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.NiveauCouverture;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ContratSanteRequestDTO(
    @NotNull LocalDate dateSouscription,
    @NotNull Double montantCotisation,
    @NotNull Integer dureeContrat,
    @NotNull Double tauxCouverture,
    @NotNull Long clientId,
    @NotNull NiveauCouverture niveauCouverture,
    @NotNull Integer nombrePersonnesCouvertes
) {}
