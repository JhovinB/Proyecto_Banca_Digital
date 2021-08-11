package com.jbac.banca_digital.usuario.domain;

import java.util.Optional;

public interface UserRepository {

	
	public Optional<User> getById(Integer id);
	
	public Optional<User> getByIdClient(Integer idCliente);

	public Optional<User> getByIdAndClave(Integer idCliente, String clave);
	
	public Optional<User> save(User user);
}
