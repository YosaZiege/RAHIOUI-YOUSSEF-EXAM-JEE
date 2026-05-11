package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.TypeLogement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ContratHabitationRequestDTO(
    @NotNull LocalDate dateSouscription,
    @NotNull Double montantCotisation,
    @NotNull Integer dureeContrat,
    @NotNull Double tauxCouverture,
    @NotNull Long clientId,
    @NotNull TypeLogement typeLogement,
    @NotBlank String adresse,
    @NotNull Double superficie
) {}
