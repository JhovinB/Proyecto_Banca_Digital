package com.jbac.banca_digital.operacion.infraestructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/operaciones")
public class OperationWebController {

	@ModelAttribute("modulo")
	public String modulo() {
		return "operaciones";
	}
	
	@GetMapping(value={"","/"})
	public String operation() {
		return "operaciones/operaciones";
	}
}

