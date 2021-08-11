package com.jbac.banca_digital.tarjeta.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbac.banca_digital.tarjeta.application.create.CardCreateService;
import com.jbac.banca_digital.tarjeta.application.delete.CardDeleteService;
import com.jbac.banca_digital.tarjeta.application.finder.CardFinderService;
import com.jbac.banca_digital.tarjeta.application.update.CardUpdateService;
import com.jbac.banca_digital.tarjeta.domain.Card;
import com.jbac.banca_digital.tarjeta.domain.CardUpdateException;

@RestController
@RequestMapping("/api/v1/tarjetas")
public class CardRestController {
	
	@Autowired
	private CardFinderService cardFinderService;
	
	@Autowired
	private CardCreateService cardCreateService;
	
	
	@Autowired
	private CardUpdateService cardUpdateService;
	
	@Autowired
	private CardDeleteService cardDeleteService;
	
	@GetMapping
	public List<Card> listarTarjetas() {
		Optional<List<Card>> oCards = cardFinderService.listCard();
		return oCards.get();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Card> obtenerTarjeta(@PathVariable Integer id) {
		Optional<Card> oCard = cardFinderService.getCard(id);
		
		if(oCard.isPresent()) {
			return ResponseEntity.ok(oCard.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Card> crearTarjeta(@RequestBody Card card) {
		return ResponseEntity.ok(cardCreateService.registerCard(card).get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Card> actualizarTarjeta(@PathVariable("id") Integer id, @RequestBody Card card) {
		card.setId(id);
		try {
			return ResponseEntity.ok(cardUpdateService.updateCard(card).get());
		} catch (CardUpdateException e) {
			return new ResponseEntity<Card>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		if(cardFinderService.getCard(id).isPresent()) {
			cardDeleteService.deleteCard(id);
			return ResponseEntity.ok("Se eliminó");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	

}
