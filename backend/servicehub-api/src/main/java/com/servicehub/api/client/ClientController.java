package com.servicehub.api.client;

import com.servicehub.api.client.dto.ClientResponse;
import com.servicehub.api.client.dto.CreateClientRequest;
import com.servicehub.domain.client.ClientEntity;
import com.servicehub.domain.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping
  public ResponseEntity<ClientResponse> create(@RequestBody @Valid CreateClientRequest request) {
    ClientEntity createdClient = clientService.createClient(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(createdClient));
  }

  @GetMapping
  public ResponseEntity<List<ClientResponse>> findAll() {
    List<ClientResponse> responses = clientService.findAllClients()
        .stream()
        .map(this::toResponse)
        .toList();

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<ClientResponse> findById(@PathVariable UUID clientId) {
    ClientEntity client = clientService.findClientById(clientId);
    return ResponseEntity.ok(toResponse(client));
  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<Void> delete(@PathVariable UUID clientId) {
    clientService.deleteClientById(clientId);
    return ResponseEntity.noContent().build();
  }

  private ClientResponse toResponse(ClientEntity clientEntity) {
    return new ClientResponse(
        clientEntity.getId(),
        clientEntity.getName(),
        clientEntity.getEmail(),
        clientEntity.getPhone(),
        clientEntity.getCreatedAt(),
        clientEntity.getUpdatedAt()
    );
  }
}
