package com.rahioui.youssef.assurance.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ContratAutomobileRequestDTO(
    @NotNull LocalDate dateSouscription,
    @NotNull Double montantCotisation,
    @NotNull Integer dureeContrat,
    @NotNull Double tauxCouverture,
    @NotNull Long clientId,
    @NotBlank String numeroImmatriculation,
    @NotBlank String marqueVehicule,
    @NotBlank String modeleVehicule
) {}
