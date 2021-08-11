package com.jbac.banca_digital.shared.domain;

public enum SessionKeys {

	
	CLIENTE_LOGIN("clienteLogin");
	
	private String value;

	private SessionKeys(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
}
