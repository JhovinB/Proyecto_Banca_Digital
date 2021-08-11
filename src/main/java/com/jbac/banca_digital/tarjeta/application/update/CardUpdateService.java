package com.jbac.banca_digital.tarjeta.application.update;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jbac.banca_digital.tarjeta.domain.Card;
import com.jbac.banca_digital.tarjeta.domain.CardRepository;
import com.jbac.banca_digital.tarjeta.domain.CardUpdateException;

@Service
public class CardUpdateService {
	
	
	private CardRepository cardRepository;

	public CardUpdateService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	public Optional<Card> updateCard(Card card) throws CardUpdateException{
		return Optional.ofNullable(cardRepository.updateAll(card)
				.orElseThrow(CardUpdateException::new));
	}
	
	
	
	
	
}
