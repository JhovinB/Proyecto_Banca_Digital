package com.jbac.banca_digital.tarjeta.application.finder;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jbac.banca_digital.tarjeta.domain.Card;
import com.jbac.banca_digital.tarjeta.domain.CardRepository;

@Service
public class CardFinderService {
	
	private CardRepository cardRepository;
	
	
	public CardFinderService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	
	public Optional<List<Card>> listCard(){
		return cardRepository.findAll();
	}
	
	public Optional<List<Card>> listCards(Integer idCliente){
		return cardRepository.findByIdClient(idCliente);
	}


	public Optional<Card> getCard(Integer idTarjeta) {
		return cardRepository.findById(idTarjeta);
	}
	
}
