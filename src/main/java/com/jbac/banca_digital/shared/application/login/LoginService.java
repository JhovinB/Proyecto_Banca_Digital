package com.jbac.banca_digital.shared.application.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.cliente.domain.ClientRepository;
import com.jbac.banca_digital.shared.domain.BadCredentialsException;
import com.jbac.banca_digital.shared.domain.UserNotFoundException;
import com.jbac.banca_digital.usuario.domain.User;
import com.jbac.banca_digital.usuario.domain.UserRepository;

@Service
public class LoginService {
	
	
	private UserRepository userRepository;
	
	private ClientRepository clientRepository;
	
	public LoginService(
		@Qualifier("userRepositoryImpl")
		UserRepository userRepository, ClientRepository clientRepository) {
		this.userRepository = userRepository;
		this.clientRepository = clientRepository;
	}

	public User validateUser(String user) throws UserNotFoundException {
		
		User userLogin = null;

		Optional<Client> oClient = clientRepository.getByDocument(user);

		if (oClient.isPresent()) {
			userLogin = userRepository.getByIdClient(oClient.get().getId()).get();
			userLogin.setClient(oClient.get());
		} else {
			throw new UserNotFoundException();
		}

		return userLogin;
	}


	public User validateUserClave(String user,String clave)
			throws UserNotFoundException,BadCredentialsException {
		
		User userLogin = null;
		
		Optional<Client> oClient = clientRepository.getByDocument(user);
		
		if(oClient.isPresent()) {
			userLogin = userRepository.getByIdAndClave
					(oClient.get().getId(),clave)
					.orElseThrow(BadCredentialsException::new);
		userLogin.setClient(oClient.get());
		}else {
			throw new UserNotFoundException();
		}
		
		return userLogin;
	}

}
