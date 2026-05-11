package com.rahioui.youssef.assurance.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_roles")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String roleName;

    private String description;
}
