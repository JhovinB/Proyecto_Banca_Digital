package com.jbac.banca_digital.usuario.infraestructure.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends  CrudRepository<UserEntity,Integer>{

	Optional<UserEntity> findByIdCliente(Integer idCliente);
	
	Optional<UserEntity> findByIdClienteAndClave(Integer idCliente,String clave);

}
