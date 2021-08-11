package com.jbac.banca_digital.tarjeta.domain;

import java.util.List;
import java.util.Optional;

public interface CardRepository {
	
	public Optional<List<Card>> findAll();
	
	public Optional<List<Card>> findByIdClient(Integer idCliente);

	public Optional<Card> findById(Integer id);
	
	public Card save(Card card);
	
	public boolean delete(Integer id);

	public Optional<Card> updateAll(Card card);
}
