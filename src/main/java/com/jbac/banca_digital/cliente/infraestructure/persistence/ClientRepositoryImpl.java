package com.jbac.banca_digital.cliente.infraestructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.cliente.domain.ClientRepository;

@Repository
public class ClientRepositoryImpl implements ClientRepository{
	
	private ClientMapper clientMapper;
	
	
	/*Se esta inyectando un cliente Mapper
	No es necesario el autowired->es automatico xq tienes un unico constructor*/
	public ClientRepositoryImpl(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

	@Override
	public List<Client> getAll() {
		return clientMapper.findAll();
	}

	@Override
	public Optional<Client> getById(Integer id) {
		return Optional.ofNullable(clientMapper.findById(id));
	}

	@Override
	public Optional<Client> getByDocument(String documento) {
		return Optional.ofNullable(clientMapper.findByDocumento(documento));
	}

	@Override
	public Client save(Client client) {
		int row = clientMapper.insert(client);
		return row == 0? null:client;
	}

	@Override
	public boolean delete(Integer id) {
		int row = clientMapper.delete(id);
		return row == 0? false : true;
	}

	@Override
	public Optional<Client> updateAll(Client client) {
		int row = clientMapper.update(client);
		//Si no actualizo al cliente: Si ya actualizo el cliente
		return row == 0? Optional.empty() : Optional.of(client);
	}

}
