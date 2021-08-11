package com.jbac.banca_digital.tarjeta.application.delete;

import org.springframework.stereotype.Service;

import com.jbac.banca_digital.tarjeta.domain.CardRepository;

@Service
public class CardDeleteService {
	
	
	private CardRepository cardRepository;

	public CardDeleteService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	public boolean deleteCard(Integer idTarjeta) {
		return cardRepository.delete(idTarjeta);
	}
	
	
	
	
}
