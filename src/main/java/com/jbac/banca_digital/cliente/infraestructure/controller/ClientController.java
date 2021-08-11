package com.jbac.banca_digital.cliente.infraestructure.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbac.banca_digital.cliente.application.finder.ClientFinderService;
import com.jbac.banca_digital.cliente.domain.Client;

@Controller
@RequestMapping
public class ClientController {
	
	
	@Autowired
	private ClientFinderService clientService;
	
	public Collection<Client> listClients() {
		return clientService.getClients();
	}
	
	

}
