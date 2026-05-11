package com.rahioui.youssef.assurance.services;

import com.rahioui.youssef.assurance.dtos.ClientRequestDTO;
import com.rahioui.youssef.assurance.dtos.ClientResponseDTO;

import java.util.List;

public interface IClientService {
    ClientResponseDTO createClient(ClientRequestDTO dto);
    ClientResponseDTO getClientById(Long id);
    List<ClientResponseDTO> getAllClients();
    ClientResponseDTO updateClient(Long id, ClientRequestDTO dto);
    void deleteClient(Long id);
    List<ClientResponseDTO> searchByNom(String nom);
}
