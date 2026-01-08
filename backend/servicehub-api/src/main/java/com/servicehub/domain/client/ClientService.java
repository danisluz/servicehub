package com.servicehub.domain.client;

import com.servicehub.api.client.dto.CreateClientRequest;
import com.servicehub.domain.shared.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

  private ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public ClientEntity createClient(CreateClientRequest request) {
    ClientEntity clientEntity = new ClientEntity();
    clientEntity.setName(request.name());
    clientEntity.setEmail(request.email());
    clientEntity.setPhone(request.phone());

    return clientRepository.save(clientEntity);
  }

  public List<ClientEntity> findAllClients() {
    return clientRepository.findAll();
  }

  public ClientEntity findClientById(UUID clientId) {
    return clientRepository.findById(clientId)
        .orElseThrow(() -> new NotFoundException("Client not found: " + clientId));
  }

  public void deleteClientById(UUID clientId) {
    if (!clientRepository.existsById(clientId)) {
      throw new NotFoundException("Client not found: " + clientId);
    }

    clientRepository.deleteById(clientId);
  }
}
