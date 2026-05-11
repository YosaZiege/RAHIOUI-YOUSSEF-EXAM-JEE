package com.rahioui.youssef.assurance.entities;

import com.rahioui.youssef.assurance.enums.TypeLogement;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@DiscriminatorValue("HABITATION")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ContratAssuranceHabitation extends ContratAssurance {

    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;

    private String adresse;

    private Double superficie;
}
