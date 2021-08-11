package com.jbac.banca_digital.resumen.infraestructure.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbac.banca_digital.cliente.application.finder.ClientFinderService;
import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.shared.domain.SessionKeys;

@Controller
@RequestMapping("/resumen")
public class ResumeWebController {
	
	private static Logger log= LoggerFactory.getLogger(ResumeWebController.class);
	
	@Autowired
	private ClientFinderService clientFinderService;
	
	
	@ModelAttribute("modulo")
	public String modulo() {
		return "resumen";
	}
	
	@GetMapping(value={"","/"})
	public String home(HttpSession session,ModelMap model) {
		
		
		Client clientSession = (Client)session.getAttribute(SessionKeys.CLIENTE_LOGIN.getValue());
		
		log.debug(clientSession.toString());
		
		clientFinderService.consultById(clientSession.getId())
				.ifPresent(cli->model.addAttribute("cliente",cli));
		
		return "resumen/resumen";
	}
}
