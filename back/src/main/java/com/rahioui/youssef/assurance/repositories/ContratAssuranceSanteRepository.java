package com.rahioui.youssef.assurance.repositories;

import com.rahioui.youssef.assurance.entities.ContratAssuranceSante;
import com.rahioui.youssef.assurance.enums.NiveauCouverture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratAssuranceSanteRepository extends JpaRepository<ContratAssuranceSante, Long> {
    List<ContratAssuranceSante> findByNiveauCouverture(NiveauCouverture niveau);
}
