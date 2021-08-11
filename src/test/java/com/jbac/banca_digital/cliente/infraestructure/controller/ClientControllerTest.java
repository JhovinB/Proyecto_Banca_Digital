package com.jbac.banca_digital.cliente.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.jbac.banca_digital.cliente.domain.Client;

@SpringBootTest
@ContextConfiguration
public class ClientControllerTest {
	
	private static Logger log= LoggerFactory.getLogger(ClientControllerTest.class);
	@Autowired
	private ClientController clientController;
	
	@Test
	@DisplayName("Validar que se obtenga lista de clientes")
	public void findListClient() {
		
		Collection<Client> list = clientController.listClients();
		
		list.forEach(client->log.debug(client.toString()));
		
		assertEquals(false,list.isEmpty());
		
	}
	
	
	
	

}
