package com.rahioui.youssef.assurance.mappers;

import com.rahioui.youssef.assurance.dtos.PaiementRequestDTO;
import com.rahioui.youssef.assurance.dtos.PaiementResponseDTO;
import com.rahioui.youssef.assurance.entities.ContratAssurance;
import com.rahioui.youssef.assurance.entities.Paiement;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public Paiement toEntity(PaiementRequestDTO dto, ContratAssurance contrat) {
        return Paiement.builder()
                .date(dto.date())
                .montant(dto.montant())
                .type(dto.type())
                .contrat(contrat)
                .build();
    }

    public PaiementResponseDTO toDTO(Paiement p) {
        return new PaiementResponseDTO(p.getId(), p.getDate(), p.getMontant(),
                p.getType(), p.getContrat().getId());
    }
}
