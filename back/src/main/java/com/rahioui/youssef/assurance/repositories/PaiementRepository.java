package com.rahioui.youssef.assurance.repositories;

import com.rahioui.youssef.assurance.entities.Paiement;
import com.rahioui.youssef.assurance.enums.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContratId(Long contratId);
    List<Paiement> findByType(TypePaiement type);
}
