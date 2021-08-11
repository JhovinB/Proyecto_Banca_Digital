package com.jbac.banca_digital.cliente.infraestructure.persistence;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jbac.banca_digital.tarjeta.infraestructure.persistence.CardEntity;
import com.jbac.banca_digital.usuario.infraestructure.persistence.UserEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude={"user","tarjetas"})
@Entity
@Table(name="cliente")
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="serial")
	private Integer idCliente;
	
	@Column
	private String nombres;
	
	@Column
	private String documento;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@OneToOne(mappedBy = "client",fetch = FetchType.LAZY)
	private UserEntity user;
	
	@OneToMany(mappedBy = "client")
	private List<CardEntity> tarjetas;

	
}
