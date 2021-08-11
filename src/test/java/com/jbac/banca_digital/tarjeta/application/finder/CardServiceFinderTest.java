package com.jbac.banca_digital.tarjeta.application.finder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.jbac.banca_digital.cliente.infraestructure.controller.ClientControllerTest;
import com.jbac.banca_digital.tarjeta.domain.Card;

@SpringBootTest
@ContextConfiguration
public class CardServiceFinderTest {
	
	private static Logger log= LoggerFactory.getLogger(ClientControllerTest.class);
	
	@Autowired
	private CardFinderService cardFinderService;
	
	@Test
	public void listCards() {
		
		Integer idCliente = 1;
		
		Optional<List<Card>> list = cardFinderService.listCards(idCliente);
		
		list.ifPresent(cards->cards.forEach(card->log.info(card.toString())));
	
		assertNotNull(list.get());
		
	}
	
	
}
