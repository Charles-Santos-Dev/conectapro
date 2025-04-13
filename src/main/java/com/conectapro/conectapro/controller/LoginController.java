package com.conectapro.conectapro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conectapro.conectapro.PasswordService;
import com.conectapro.conectapro.DTO.LoginRequestDTO;
import com.conectapro.conectapro.DTO.ResponseDTO;
import com.conectapro.conectapro.entity.UserEntity;
import com.conectapro.conectapro.service.JwtService;
import com.conectapro.conectapro.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordService passwordService;
    
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO userDTO) {
    	
		ResponseDTO response = new ResponseDTO();
		HttpStatus status;
		
		UserEntity userLogin = this.userService.findByLogin(userDTO.getLogin());
		
		if(userLogin == null) {
			
	    	response.setMessage("Usuário não existe");
	    	status = HttpStatus.NOT_FOUND;
		
		} else {
			
			boolean validateUser = this.passwordService.checkPassword(userDTO.getPassword(), userLogin.getPassword());
			
			if(validateUser) {
		    	response.setJwt(this.jwtService.generateToken(userLogin.getLogin()));
		    	response.setMessage("OK");
		    	status = HttpStatus.OK;
			} else {
		    	response.setMessage("Senha não confere");
		    	status = HttpStatus.UNAUTHORIZED;
			}
		
		}

		return new ResponseEntity<>(response, status);
    }
	
	@GetMapping("/teste")
    public ResponseEntity<ResponseDTO> teste() {
    	
    	ResponseDTO response = new ResponseDTO();
    	HttpStatus status = HttpStatus.OK;
    	
    	logger.debug("Mensagem de Teste...");
    	
    	response.setMessage("Teste...");
    	
    	return new ResponseEntity<>(response, status);
    }
}