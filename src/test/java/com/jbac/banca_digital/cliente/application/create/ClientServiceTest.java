package com.jbac.banca_digital.cliente.application.create;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.jbac.banca_digital.cliente.domain.Client;

@SpringBootTest
@ContextConfiguration
public class ClientServiceTest {

	private static Logger log= LoggerFactory.getLogger(ClientServiceTest.class);
	@Autowired
	private ClientCreateService clientCreateService;
	
	@Test
	public void registerClient() {
		
		Client client = new Client("Jbac","72046649",LocalDate.of(1999,05,26));
		
		Client clientSave = clientCreateService.saveClient(client);
		
		log.debug("New Client "+clientSave.toString());
		
		assertNotNull(clientSave.getId());
	}
}
