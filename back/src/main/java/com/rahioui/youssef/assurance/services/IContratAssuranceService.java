package com.rahioui.youssef.assurance.services;

import com.rahioui.youssef.assurance.dtos.*;
import com.rahioui.youssef.assurance.enums.StatutContrat;

import java.util.List;

public interface IContratAssuranceService {
    ContratAutomobileResponseDTO createContratAutomobile(ContratAutomobileRequestDTO dto);
    ContratHabitationResponseDTO createContratHabitation(ContratHabitationRequestDTO dto);
    ContratSanteResponseDTO createContratSante(ContratSanteRequestDTO dto);

    ContratAssuranceResponseDTO getContratById(Long id);
    List<ContratAssuranceResponseDTO> getAllContrats();
    List<ContratAssuranceResponseDTO> getContratsByClient(Long clientId);
    List<ContratAssuranceResponseDTO> getContratsByStatut(StatutContrat statut);

    ContratAssuranceResponseDTO validerContrat(Long id);
    ContratAssuranceResponseDTO resilierContrat(Long id);
    void deleteContrat(Long id);
}
