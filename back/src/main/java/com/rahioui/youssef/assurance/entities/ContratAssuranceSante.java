package com.rahioui.youssef.assurance.entities;

import com.rahioui.youssef.assurance.enums.NiveauCouverture;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@DiscriminatorValue("SANTE")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ContratAssuranceSante extends ContratAssurance {

    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;

    private Integer nombrePersonnesCouvertes;
}
