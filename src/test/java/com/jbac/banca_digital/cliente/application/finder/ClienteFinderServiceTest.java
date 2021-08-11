package com.jbac.banca_digital.cliente.application.finder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.jbac.banca_digital.cliente.application.create.ClientServiceTest;
import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.cliente.domain.ClientNotFoundException;

@SpringBootTest
@ContextConfiguration
public class ClienteFinderServiceTest {
	
	private static Logger log= LoggerFactory.getLogger(ClientServiceTest.class);
	
	@Autowired
	private ClientFinderService clientFinderService;

	@Test
	public void consultByDocument() throws ClientNotFoundException {
		
		String document="72046649";
	
		Optional<Client> client = clientFinderService.consultByDocument(document);
		
		client.ifPresent(cli->log.info(cli.toString()));
		
		assertNotNull(client.get());
		
	}
	
	
	
}
