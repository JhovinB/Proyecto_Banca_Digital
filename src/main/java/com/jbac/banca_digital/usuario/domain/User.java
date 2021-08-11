package com.jbac.banca_digital.usuario.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jbac.banca_digital.cliente.domain.Client;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class User {
	
	@NonNull
	private Integer id;
	
	@NonNull
	private Integer idCliente;
	
	@NonNull
	@JsonIgnore
	private String clave;
	
	private Client client;

	public User(@NonNull Integer idCliente, @NonNull String clave) {
		this.idCliente = idCliente;
		this.clave = clave;
	}

	
	
	
	
}
