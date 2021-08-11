package com.jbac.banca_digital.tarjeta.domain;

public enum CardStatusEnum {
	
	ACTIVA("Activa"),BLOQUEADA("Bloqueado"),INACTIVA("Inactiva");
	
	private String label;
	
	private CardStatusEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
