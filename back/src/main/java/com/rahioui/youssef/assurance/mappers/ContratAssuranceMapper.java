package com.rahioui.youssef.assurance.mappers;

import com.rahioui.youssef.assurance.dtos.*;
import com.rahioui.youssef.assurance.entities.*;
import com.rahioui.youssef.assurance.enums.StatutContrat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContratAssuranceMapper {

    public ContratAssuranceResponseDTO toDTO(ContratAssurance c) {
        String type = c instanceof ContratAssuranceAutomobile ? "AUTOMOBILE"
                    : c instanceof ContratAssuranceHabitation ? "HABITATION" : "SANTE";
        return new ContratAssuranceResponseDTO(
                c.getId(), type, c.getDateSouscription(), c.getStatut(),
                c.getDateValidation(), c.getMontantCotisation(), c.getDureeContrat(),
                c.getTauxCouverture(), c.getClient().getId(), c.getClient().getNom());
    }

    public ContratAssuranceAutomobile toAutomobileEntity(ContratAutomobileRequestDTO dto, Client client) {
        ContratAssuranceAutomobile c = new ContratAssuranceAutomobile();
        mapCommonFields(c, dto.dateSouscription(), dto.montantCotisation(), dto.dureeContrat(), dto.tauxCouverture(), client);
        c.setNumeroImmatriculation(dto.numeroImmatriculation());
        c.setMarqueVehicule(dto.marqueVehicule());
        c.setModeleVehicule(dto.modeleVehicule());
        return c;
    }

    public ContratAutomobileResponseDTO toAutomobileDTO(ContratAssuranceAutomobile c) {
        return new ContratAutomobileResponseDTO(
                c.getId(), c.getDateSouscription(), c.getStatut(), c.getDateValidation(),
                c.getMontantCotisation(), c.getDureeContrat(), c.getTauxCouverture(),
                c.getClient().getId(), c.getClient().getNom(),
                c.getNumeroImmatriculation(), c.getMarqueVehicule(), c.getModeleVehicule());
    }

    public ContratAssuranceHabitation toHabitationEntity(ContratHabitationRequestDTO dto, Client client) {
        ContratAssuranceHabitation c = new ContratAssuranceHabitation();
        mapCommonFields(c, dto.dateSouscription(), dto.montantCotisation(), dto.dureeContrat(), dto.tauxCouverture(), client);
        c.setTypeLogement(dto.typeLogement());
        c.setAdresse(dto.adresse());
        c.setSuperficie(dto.superficie());
        return c;
    }

    public ContratHabitationResponseDTO toHabitationDTO(ContratAssuranceHabitation c) {
        return new ContratHabitationResponseDTO(
                c.getId(), c.getDateSouscription(), c.getStatut(), c.getDateValidation(),
                c.getMontantCotisation(), c.getDureeContrat(), c.getTauxCouverture(),
                c.getClient().getId(), c.getClient().getNom(),
                c.getTypeLogement(), c.getAdresse(), c.getSuperficie());
    }

    public ContratAssuranceSante toSanteEntity(ContratSanteRequestDTO dto, Client client) {
        ContratAssuranceSante c = new ContratAssuranceSante();
        mapCommonFields(c, dto.dateSouscription(), dto.montantCotisation(), dto.dureeContrat(), dto.tauxCouverture(), client);
        c.setNiveauCouverture(dto.niveauCouverture());
        c.setNombrePersonnesCouvertes(dto.nombrePersonnesCouvertes());
        return c;
    }

    public ContratSanteResponseDTO toSanteDTO(ContratAssuranceSante c) {
        return new ContratSanteResponseDTO(
                c.getId(), c.getDateSouscription(), c.getStatut(), c.getDateValidation(),
                c.getMontantCotisation(), c.getDureeContrat(), c.getTauxCouverture(),
                c.getClient().getId(), c.getClient().getNom(),
                c.getNiveauCouverture(), c.getNombrePersonnesCouvertes());
    }

    private void mapCommonFields(ContratAssurance c, LocalDate date, Double montant,
                                  Integer duree, Double taux, Client client) {
        c.setDateSouscription(date);
        c.setStatut(StatutContrat.EN_COURS);
        c.setMontantCotisation(montant);
        c.setDureeContrat(duree);
        c.setTauxCouverture(taux);
        c.setClient(client);
    }
}
