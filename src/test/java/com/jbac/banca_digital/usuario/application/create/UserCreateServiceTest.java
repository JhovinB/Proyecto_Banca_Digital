package com.jbac.banca_digital.usuario.application.create;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import com.jbac.banca_digital.cliente.infraestructure.controller.ClientControllerTest;
import com.jbac.banca_digital.usuario.domain.User;

@SpringBootTest
@ContextConfiguration
public class UserCreateServiceTest {
	
	
	private static Logger log= LoggerFactory.getLogger(ClientControllerTest.class);
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private UserCreateService userCreateService;
	
	@Test
	public void createUser() {
		
		User usu = new User(6,passwordEncoder.encode("jbac"));
		
		Optional<User> oUser = userCreateService.createUser(usu);
		
		oUser.ifPresent(u->log.info(u.toString()));
		
		assertNotNull(oUser.get());
		
		
	}
}
