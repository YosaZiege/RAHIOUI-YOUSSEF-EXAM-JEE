package com.rahioui.youssef.assurance.dtos;

import com.rahioui.youssef.assurance.enums.TypePaiement;

import java.time.LocalDate;

public record PaiementResponseDTO(
    Long id,
    LocalDate date,
    Double montant,
    TypePaiement type,
    Long contratId
) {}
