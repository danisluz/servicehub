package com.servicehub.api.client.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateClientRequest(
    @NotBlank String name,
    @Email @NotBlank String email,
    @NotBlank String phone
) {}
