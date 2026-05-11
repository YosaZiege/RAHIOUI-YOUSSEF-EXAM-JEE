package com.rahioui.youssef.assurance.repositories;

import com.rahioui.youssef.assurance.entities.ContratAssurance;
import com.rahioui.youssef.assurance.enums.StatutContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratAssuranceRepository extends JpaRepository<ContratAssurance, Long> {
    List<ContratAssurance> findByClientId(Long clientId);
    List<ContratAssurance> findByStatut(StatutContrat statut);

    @Query("SELECT c FROM ContratAssurance c JOIN FETCH c.client WHERE c.client.id = :clientId")
    List<ContratAssurance> findByClientIdWithClient(@Param("clientId") Long clientId);
}
