package com.jbac.banca_digital.shared.infraestructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jbac.banca_digital.shared.application.login.LoginService;

@Controller
public class LoginController {
	
	private static Logger log= LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/home")
	public String Home(){
		return "home";
	}

//	@GetMapping(value= {"/login","","/"})
//	public String login(){
//		return "login";
//	}
//		
//		
//	@PostMapping("/login")
//	public String valiClave(@RequestParam String documento,
//			@RequestParam String password,ModelMap modelMap,HttpSession session) {
//		
//		log.info("documento:"+documento);
//		log.info("password:"+password);
//		
//		
//		User user;
//		String resultPage="";
//		try {
//			user = loginService.validateUserClave(documento, password);
//			log.debug(user.toString());
//			session.setAttribute(SessionKeys.CLIENTE_LOGIN.getValue(),user.getClient());
//			
//			resultPage= "home";
//		} catch (UserNotFoundException |BadCredentialsException e) {
//			e.printStackTrace();
//			modelMap.addAttribute("message", "Usuario no existe o clave incorrecta");
//			resultPage= "login";
//		}
//		return resultPage;
//	}

//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute(SessionKeys.CLIENTE_LOGIN.getValue());
//		
//		return "login";
//	}
	
}
