package com.jbac.banca_digital.usuario.infraestructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jbac.banca_digital.usuario.domain.User;
import com.jbac.banca_digital.usuario.domain.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	public UserMapper userMapper;
	
	
	public UserRepositoryImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public Optional<User> getById(Integer id) {
		return Optional.ofNullable(userMapper.findById(id));
	}

	@Override
	public Optional<User> getByIdClient(Integer idCliente) {
		return Optional.ofNullable(userMapper.findByIdClient(idCliente));
	}

	@Override
	public Optional<User> getByIdAndClave(Integer id, String clave) {
		
		return Optional.ofNullable(userMapper.findByIdAndClave(id, clave));
	}

	@Override
	public Optional<User> save(User user) {
		int row = userMapper.insert(user);
		return row == 0 ? Optional.empty() : Optional.of(user);
	}

}
