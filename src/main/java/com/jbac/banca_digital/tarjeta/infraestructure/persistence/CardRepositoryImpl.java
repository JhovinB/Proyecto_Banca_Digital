package com.jbac.banca_digital.tarjeta.infraestructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jbac.banca_digital.tarjeta.domain.Card;
import com.jbac.banca_digital.tarjeta.domain.CardRepository;

@Repository
public class CardRepositoryImpl implements CardRepository{
	
	
	private CardMapper cardMapper;

	public CardRepositoryImpl(CardMapper cardMapper) {
		this.cardMapper = cardMapper;
	}

	@Override
	public Optional<List<Card>> findByIdClient(Integer idCliente) {
		return Optional.ofNullable(cardMapper.findByIdCliente(idCliente));
	}

	@Override
	public Optional<Card> findById(Integer id) {
		return Optional.ofNullable(cardMapper.findById(id));
	}

	@Override
	public Card save(Card card) {
		int row = cardMapper.insert(card);
		return row == 0? null : card;
	}

	@Override
	public boolean delete(Integer id) {
		int row = cardMapper.delete(id);
		return row == 0? false : true;
	}

	@Override
	public Optional<Card> updateAll(Card card) {
		int row = cardMapper.update(card);
		return row == 1? Optional.of(card):Optional.empty();
	}

	@Override
	public Optional<List<Card>> findAll() {
		return Optional.ofNullable(cardMapper.findAll());
	}

}
