package com.jbac.banca_digital.usuario.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ContextConfiguration
@Transactional
public class JpaUserRepositoryTest {
	
	private static Logger log= LoggerFactory.getLogger(JpaUserRepositoryTest.class);
	
	
	@Autowired
	private JpaUserRepository crudRepository;
	
	@Test
	public void consultUsers() {
		
		List<UserEntity> entities = (List<UserEntity>) crudRepository.findAll();
		
		entities.forEach(u->{
			log.info(u.toString());
			log.info(u.getClient().toString());
			log.info(u.getClient().getTarjetas().toString());
		});
		
		assertNotNull(entities);
		
	}
	
}
