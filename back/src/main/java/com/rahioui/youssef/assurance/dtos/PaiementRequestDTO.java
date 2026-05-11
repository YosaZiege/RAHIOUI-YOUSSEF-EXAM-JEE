package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.TypePaiement;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record PaiementRequestDTO(
    @NotNull LocalDate date,
    @NotNull @Positive Double montant,
    @NotNull TypePaiement type,
    @NotNull Long contratId
) {}
