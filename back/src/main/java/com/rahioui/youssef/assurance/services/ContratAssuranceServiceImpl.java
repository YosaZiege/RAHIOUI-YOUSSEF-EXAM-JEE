package com.rahioui.youssef.assurance.services;

import com.rahioui.youssef.assurance.dtos.*;
import com.rahioui.youssef.assurance.entities.*;
import com.rahioui.youssef.assurance.enums.StatutContrat;
import com.rahioui.youssef.assurance.exceptions.ResourceNotFoundException;
import com.rahioui.youssef.assurance.mappers.ContratAssuranceMapper;
import com.rahioui.youssef.assurance.repositories.ClientRepository;
import com.rahioui.youssef.assurance.repositories.ContratAssuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ContratAssuranceServiceImpl implements IContratAssuranceService {

    private final ContratAssuranceRepository contratRepository;
    private final ClientRepository clientRepository;
    private final ContratAssuranceMapper mapper;

    private Client findClient(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client non trouvé avec l'id : " + clientId));
    }

    private ContratAssurance findContrat(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat non trouvé avec l'id : " + id));
    }

    @Override
    public ContratAutomobileResponseDTO createContratAutomobile(ContratAutomobileRequestDTO dto) {
        Client client = findClient(dto.clientId());
        ContratAssuranceAutomobile contrat = mapper.toAutomobileEntity(dto, client);
        return mapper.toAutomobileDTO((ContratAssuranceAutomobile) contratRepository.save(contrat));
    }

    @Override
    public ContratHabitationResponseDTO createContratHabitation(ContratHabitationRequestDTO dto) {
        Client client = findClient(dto.clientId());
        ContratAssuranceHabitation contrat = mapper.toHabitationEntity(dto, client);
        return mapper.toHabitationDTO((ContratAssuranceHabitation) contratRepository.save(contrat));
    }

    @Override
    public ContratSanteResponseDTO createContratSante(ContratSanteRequestDTO dto) {
        Client client = findClient(dto.clientId());
        ContratAssuranceSante contrat = mapper.toSanteEntity(dto, client);
        return mapper.toSanteDTO((ContratAssuranceSante) contratRepository.save(contrat));
    }

    @Override
    @Transactional(readOnly = true)
    public ContratAssuranceResponseDTO getContratById(Long id) {
        return mapper.toDTO(findContrat(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratAssuranceResponseDTO> getAllContrats() {
        return contratRepository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratAssuranceResponseDTO> getContratsByClient(Long clientId) {
        return contratRepository.findByClientIdWithClient(clientId).stream().map(mapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratAssuranceResponseDTO> getContratsByStatut(StatutContrat statut) {
        return contratRepository.findByStatut(statut).stream().map(mapper::toDTO).toList();
    }

    @Override
    public ContratAssuranceResponseDTO validerContrat(Long id) {
        ContratAssurance contrat = findContrat(id);
        contrat.setStatut(StatutContrat.VALIDE);
        contrat.setDateValidation(LocalDate.now());
        return mapper.toDTO(contratRepository.save(contrat));
    }

    @Override
    public ContratAssuranceResponseDTO resilierContrat(Long id) {
        ContratAssurance contrat = findContrat(id);
        contrat.setStatut(StatutContrat.RESILIE);
        return mapper.toDTO(contratRepository.save(contrat));
    }

    @Override
    public void deleteContrat(Long id) {
        if (!contratRepository.existsById(id))
            throw new ResourceNotFoundException("Contrat non trouvé avec l'id : " + id);
        contratRepository.deleteById(id);
    }
}
