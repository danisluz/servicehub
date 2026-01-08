package com.servicehub.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
public class VersionController {

    @Value("${spring.application.name:servicehub-api}")
    private String applicationName;

    @Value("${servicehub.product-name:ClimaFlow}")
    private String productName;

    @GetMapping(value = "/api/v1/version", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> version() {
        return Map.of(
                "application", applicationName,
                "product", productName,
                "status", "RUNNING",
                "timestamp", OffsetDateTime.now().toString()
        );
    }

}
