package com.jbac.banca_digital.usuario.application.create;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jbac.banca_digital.usuario.domain.User;
import com.jbac.banca_digital.usuario.domain.UserRepository;

@Service
public class UserCreateService {
	
	
	private UserRepository userRepository;

	public UserCreateService(
			@Qualifier("userRepositoryImpl")
			UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Optional<User> createUser(User user){
		return userRepository.save(user);
	}
	
	
	
}
