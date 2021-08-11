package com.jbac.banca_digital.tarjeta.application.create;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jbac.banca_digital.tarjeta.domain.Card;
import com.jbac.banca_digital.tarjeta.domain.CardRepository;

@Service
public class CardCreateService {
	
	private CardRepository cardRepository;

	public CardCreateService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	public Optional<Card> registerCard(Card card){
		
		return Optional.ofNullable(cardRepository.save(card));
	}
}
