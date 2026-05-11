package com.rahioui.youssef.assurance.services;

import com.rahioui.youssef.assurance.dtos.PaiementRequestDTO;
import com.rahioui.youssef.assurance.dtos.PaiementResponseDTO;
import com.rahioui.youssef.assurance.entities.ContratAssurance;
import com.rahioui.youssef.assurance.entities.Paiement;
import com.rahioui.youssef.assurance.exceptions.ResourceNotFoundException;
import com.rahioui.youssef.assurance.mappers.PaiementMapper;
import com.rahioui.youssef.assurance.repositories.ContratAssuranceRepository;
import com.rahioui.youssef.assurance.repositories.PaiementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;
    private final ContratAssuranceRepository contratRepository;
    private final PaiementMapper paiementMapper;

    @Override
    public PaiementResponseDTO createPaiement(PaiementRequestDTO dto) {
        ContratAssurance contrat = contratRepository.findById(dto.contratId())
                .orElseThrow(() -> new ResourceNotFoundException("Contrat non trouvé avec l'id : " + dto.contratId()));
        Paiement paiement = paiementMapper.toEntity(dto, contrat);
        return paiementMapper.toDTO(paiementRepository.save(paiement));
    }

    @Override
    @Transactional(readOnly = true)
    public PaiementResponseDTO getPaiementById(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement non trouvé avec l'id : " + id));
        return paiementMapper.toDTO(paiement);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaiementResponseDTO> getPaiementsByContrat(Long contratId) {
        return paiementRepository.findByContratId(contratId).stream()
                .map(paiementMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaiementResponseDTO> getAllPaiements() {
        return paiementRepository.findAll().stream()
                .map(paiementMapper::toDTO).toList();
    }

    @Override
    public void deletePaiement(Long id) {
        if (!paiementRepository.existsById(id))
            throw new ResourceNotFoundException("Paiement non trouvé avec l'id : " + id);
        paiementRepository.deleteById(id);
    }
}
