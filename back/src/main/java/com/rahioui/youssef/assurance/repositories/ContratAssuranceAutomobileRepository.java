package com.rahioui.youssef.assurance.repositories;

import com.rahioui.youssef.assurance.entities.ContratAssuranceAutomobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContratAssuranceAutomobileRepository extends JpaRepository<ContratAssuranceAutomobile, Long> {
    Optional<ContratAssuranceAutomobile> findByNumeroImmatriculation(String numeroImmatriculation);
    List<ContratAssuranceAutomobile> findByMarqueVehiculeIgnoreCase(String marque);
}
