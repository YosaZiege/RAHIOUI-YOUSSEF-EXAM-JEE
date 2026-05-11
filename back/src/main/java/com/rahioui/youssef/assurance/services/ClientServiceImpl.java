package com.rahioui.youssef.assurance.services;

import com.rahioui.youssef.assurance.dtos.ClientRequestDTO;
import com.rahioui.youssef.assurance.dtos.ClientResponseDTO;
import com.rahioui.youssef.assurance.entities.Client;
import com.rahioui.youssef.assurance.exceptions.ResourceNotFoundException;
import com.rahioui.youssef.assurance.mappers.ClientMapper;
import com.rahioui.youssef.assurance.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO dto) {
        Client client = clientMapper.toEntity(dto);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client non trouvé avec l'id : " + id));
        return clientMapper.toDTO(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDTO).toList();
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client non trouvé avec l'id : " + id));
        client.setNom(dto.nom());
        client.setEmail(dto.email());
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id))
            throw new ResourceNotFoundException("Client non trouvé avec l'id : " + id);
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponseDTO> searchByNom(String nom) {
        return clientRepository.findByNomContainingIgnoreCase(nom).stream()
                .map(clientMapper::toDTO).toList();
    }
}
