package com.servicehub.api.client.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ClientResponse(
        UUID id,
        String name,
        String email,
        String phone,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {}
