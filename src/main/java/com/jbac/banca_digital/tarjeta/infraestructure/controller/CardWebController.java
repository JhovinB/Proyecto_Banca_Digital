package com.jbac.banca_digital.tarjeta.infraestructure.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.shared.domain.SessionKeys;
import com.jbac.banca_digital.tarjeta.application.create.CardCreateService;
import com.jbac.banca_digital.tarjeta.application.delete.CardDeleteService;
import com.jbac.banca_digital.tarjeta.application.finder.CardFinderService;
import com.jbac.banca_digital.tarjeta.application.update.CardUpdateService;
import com.jbac.banca_digital.tarjeta.domain.Card;
import com.jbac.banca_digital.tarjeta.domain.CardUpdateException;

import lombok.AllArgsConstructor;
import lombok.Data;
@Controller
@RequestMapping("/tarjetas")
public class CardWebController {
	
	
	private static Logger log= LoggerFactory.getLogger(CardWebController.class);
	
	
	@Autowired
	private CardCreateService cardCreateService;
	
	@Autowired
	private CardFinderService cardFinderService;
	
	
	@Autowired
	private CardUpdateService cardUpdateService;
	
	
	@Autowired
	private CardDeleteService cardDeleteService;
	
	@ModelAttribute("modulo")
	public String modulo() {
		return "tarjetas";
	}
	
	@GetMapping(value={"","/"})
	public String card() {
		return "tarjetas/tarjetas";
	}
	
	
	@GetMapping("/nuevo")
	private String newCard(ModelMap model) {
		model.put("tarjetaNueva",new Card());
		return "tarjetas/tarjeta-nuevo";
	}
	
	@PostMapping("/registrar")
	public String registerCard(@ModelAttribute("tarjetaNueva") @Valid Card card,
			BindingResult binding,ModelMap model,HttpSession session) {
		
		String resultPage ="";
		
		if(binding.hasErrors()) {
			resultPage="tarjetas/tarjeta-nuevo";
			model.put("message","Revise los campos ingresados");
		}else {
		
			Client cli = (Client) session.getAttribute(SessionKeys.CLIENTE_LOGIN.getValue());
			card.setIdCliente(cli.getId());

			Optional<Card> oCard = cardCreateService.registerCard(card);
			
			if (oCard.isPresent()) {
				log.info(oCard.get().toString());
				resultPage = "redirect:/resumen";
			} else {
				model.put("message", "No se pudo registrar");
				resultPage = "tarjetas/tarjeta-nuevo";
			}
		}
		return resultPage;
	}
	
	@GetMapping("/editar/{id}")
	public String getCard(@PathVariable("id") Integer idTarjeta,ModelMap model) {
		
		Optional<Card> oCard = cardFinderService.getCard(idTarjeta);
		
		oCard.ifPresent(c->model.put("tarjetaEditar",c));
		oCard.ifPresent(c->log.info(c.toString()));
		
		return "tarjetas/tarjeta-editar";
	
	
	}
	@PostMapping("/editar/{id}")
	public String updateCard(@ModelAttribute("tarjetaEditar")@Valid Card card, 
			BindingResult binding,ModelMap model){
		
		String resultPage = "";
		
		if(binding.hasErrors()) {
			resultPage = "tarjetas/tarjeta-editar";
			model.put("message", "Revise los campos ingresados");
		} else {
			Optional<Card> oCard;
			try {
				oCard = cardUpdateService.updateCard(card);
				if(oCard.isPresent()) {
					log.info(oCard.get().toString());
					
					resultPage = "redirect:/resumen";
				}
			} catch (CardUpdateException e) {
				model.put("message","No se pudo registrar");
				resultPage = "tarjetas/tarjeta-nuevo";
			}
				 
		}
		
		return resultPage;
	}
	
	@PostMapping("/eliminar/{id}")
	@ResponseBody
	public ResponseEntity<EliminarResponse> deleteCard(@PathVariable("id") Integer idTarjeta,ModelMap model) {
		
		boolean result = cardDeleteService.deleteCard(idTarjeta);
		
		ResponseEntity<EliminarResponse>response=null;
		
		if(result) {
			response=new ResponseEntity<>(new EliminarResponse("Se eliminó correctamente"),HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(new EliminarResponse("Se eliminó correctamente"),HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	
	
	}
	@Data
	@AllArgsConstructor
	class EliminarResponse{
		private String message;
	}
	
	
}

