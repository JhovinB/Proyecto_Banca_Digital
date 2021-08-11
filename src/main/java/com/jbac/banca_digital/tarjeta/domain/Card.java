package com.jbac.banca_digital.tarjeta.domain;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jbac.banca_digital.cliente.domain.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Card {
	
	@NonNull
	private Integer id;
	
	@NonNull
	private Integer idCliente;
	
	@NonNull
	@NotBlank(message="Registre un número de tarjeta")
	@Size(min=19,max=19,message="Tarjeta debe tener 19 caracteres")
	private String numeroTarjeta;
	
	@NonNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull(message="Debe registrar una fecha de vencimiento")
	@FutureOrPresent(message="Fecha debe ser mayor a la fecha actual")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	private LocalDate fechaVencimiento;
	
	@NonNull
	@NotNull(message="Debe seleccionar un estado")
	private CardStatusEnum estado;
	
	//Para asociar al cliente con tarjeta
	private Client client;
	
}
