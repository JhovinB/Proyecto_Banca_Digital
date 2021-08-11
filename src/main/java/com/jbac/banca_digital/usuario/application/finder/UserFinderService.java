package com.jbac.banca_digital.usuario.application.finder;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jbac.banca_digital.usuario.domain.User;
import com.jbac.banca_digital.usuario.domain.UserRepository;

@Service
public class UserFinderService {
	
	private UserRepository userRepository;

	public UserFinderService(
			@Qualifier("userRepositoryImpl")
			UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Optional<User> getUser(Integer id){
		return userRepository.getById(id);
	}
	
	public boolean validateClave(User user) {
		return userRepository.getByIdAndClave(user.getId(),
				user.getClave()).map(usu->true).orElse(false);
	}
}
