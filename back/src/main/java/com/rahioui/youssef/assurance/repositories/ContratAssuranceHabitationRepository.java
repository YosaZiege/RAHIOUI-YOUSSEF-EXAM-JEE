package com.rahioui.youssef.assurance.repositories;

import com.rahioui.youssef.assurance.entities.ContratAssuranceHabitation;
import com.rahioui.youssef.assurance.enums.TypeLogement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratAssuranceHabitationRepository extends JpaRepository<ContratAssuranceHabitation, Long> {
    List<ContratAssuranceHabitation> findByTypeLogement(TypeLogement typeLogement);
}
