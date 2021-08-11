package com.jbac.banca_digital.shared.infraestructure.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.jbac.banca_digital.cliente.application.finder.ClientFinderService;
import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.cliente.domain.ClientNotFoundException;
import com.jbac.banca_digital.shared.domain.SessionKeys;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{

	@Autowired
	private ClientFinderService clientFinderService;
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String username = ((User) authentication.getPrincipal()).getUsername();
		String defaultPage = "/error";
		
		Optional<Client> oClient;
		try {
			oClient = clientFinderService.consultByDocument(username);
			if(oClient.isPresent()) {
				request.getSession().setAttribute(SessionKeys.CLIENTE_LOGIN.getValue(), oClient.get());
				defaultPage = "/home";
			}
		} catch (ClientNotFoundException e) {
			
		}
		
		new DefaultRedirectStrategy().sendRedirect(request, response, defaultPage);
		
	}

}
