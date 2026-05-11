package com.rahioui.youssef.assurance.services;

import com.rahioui.youssef.assurance.dtos.PaiementRequestDTO;
import com.rahioui.youssef.assurance.dtos.PaiementResponseDTO;

import java.util.List;

public interface IPaiementService {
    PaiementResponseDTO createPaiement(PaiementRequestDTO dto);
    PaiementResponseDTO getPaiementById(Long id);
    List<PaiementResponseDTO> getPaiementsByContrat(Long contratId);
    List<PaiementResponseDTO> getAllPaiements();
    void deletePaiement(Long id);
}
