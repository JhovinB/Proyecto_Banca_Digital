package com.jbac.banca_digital.cliente.domain;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
	
	public List<Client> getAll();
	
	public Optional<Client> getById(Integer id);
	
	public Optional<Client> getByDocument(String documento);
	
	public Client save(Client client);
	
	public boolean delete(Integer id);
	
	//Actualice todos los campos
	public Optional<Client> updateAll(Client client);

}
