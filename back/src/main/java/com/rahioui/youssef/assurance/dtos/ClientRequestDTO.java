package com.rahioui.youssef.assurance.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDTO(
    @NotBlank String nom,
    @Email @NotBlank String email
) {}
