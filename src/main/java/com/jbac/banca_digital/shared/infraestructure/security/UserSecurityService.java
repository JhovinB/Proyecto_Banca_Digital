package com.jbac.banca_digital.shared.infraestructure.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jbac.banca_digital.shared.application.login.LoginService;
import com.jbac.banca_digital.shared.domain.UserNotFoundException;
import com.jbac.banca_digital.usuario.domain.User;

@Service
public class UserSecurityService implements UserDetailsService {
	
	@Autowired
	private LoginService loginService;
	
	//Identificar el usuario haya ingresado en el login
	//validar si existe o no existe en la BD
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		
		try {
			User usu = loginService.validateUser(username);
			
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			
			userDetails = new org.springframework.security.core.userdetails.User
					(usu.getClient().getDocumento(), usu.getClave(), authorities);
			
		} catch (UserNotFoundException e) {
			
		}

		return userDetails;
	}

}
