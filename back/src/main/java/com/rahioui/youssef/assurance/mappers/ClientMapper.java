package com.rahioui.youssef.assurance.mappers;

import com.rahioui.youssef.assurance.dtos.ClientRequestDTO;
import com.rahioui.youssef.assurance.dtos.ClientResponseDTO;
import com.rahioui.youssef.assurance.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequestDTO dto) {
        return Client.builder()
                .nom(dto.nom())
                .email(dto.email())
                .build();
    }

    public ClientResponseDTO toDTO(Client client) {
        return new ClientResponseDTO(client.getId(), client.getNom(), client.getEmail());
    }
}
