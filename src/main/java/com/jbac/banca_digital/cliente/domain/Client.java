package com.jbac.banca_digital.cliente.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jbac.banca_digital.tarjeta.domain.Card;
import com.jbac.banca_digital.usuario.domain.User;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@RequiredArgsConstructor
@ToString
public class Client {
	
	@NonNull
	private Integer id;
	@NonNull
	private String nombres;
	@NonNull
	private String documento;
	@NonNull
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	private LocalDate fechaNacimiento;
	
	private User usuario;
	
	private List<Card> tarjetas;

	public Client(String nombres, String documento, LocalDate fechaNacimiento) {
		this.nombres = nombres;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
