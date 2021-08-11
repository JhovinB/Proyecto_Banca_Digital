package com.jbac.banca_digital.cliente.application.finder;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.cliente.domain.ClientNotFoundException;
import com.jbac.banca_digital.cliente.domain.ClientRepository;

@Service
public class ClientFinderService{
	
	private ClientRepository clientRepository;
	
	public ClientFinderService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Collection<Client> getClients() {
		return clientRepository.getAll();
	}
	
	public Optional<Client> consultByDocument(String documento) throws ClientNotFoundException{
		return Optional.ofNullable(clientRepository.getByDocument(documento)
				//Se esta creando una exception
				.orElseThrow(ClientNotFoundException::new));//Constructor de referencia
	}

	public Optional<Client> consultById(Integer id) {
		return clientRepository.getById(id);
	}
}
