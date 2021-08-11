package com.jbac.banca_digital.cliente.application.create;

import org.springframework.stereotype.Service;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.cliente.domain.ClientRepository;

@Service
public class ClientCreateService{
	
	private ClientRepository clientRepository;
	
	public ClientCreateService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client saveClient(Client client) {
		return clientRepository.save(client);
		
	}


}
