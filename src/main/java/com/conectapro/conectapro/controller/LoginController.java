package com.conectapro.conectapro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conectapro.conectapro.PasswordService;
import com.conectapro.conectapro.DTO.LoginRequestDTO;
import com.conectapro.conectapro.DTO.ResponseDTO;
import com.conectapro.conectapro.entity.UserEntity;
import com.conectapro.conectapro.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordService passwordService;
    
	@PostMapping("/login")
    public ResponseDTO login(@RequestBody LoginRequestDTO userLogin) {
    	
		List<UserEntity> users = this.userService.findAllUsers();
		
		for(UserEntity user : users) {
			
			if(this.passwordService.checkPassword(userLogin.getPassword(), user.getPassword())) {
				System.out.println("Teste - " + user.getLogin());
			}
			
		}
		
    	ResponseDTO response = new ResponseDTO();
    	
    	response.setCode(0);
    	response.setMessage("ok");
    	
        return response;
    }
	
	@GetMapping("/teste")
    public ResponseDTO teste() {
    	
		
    	ResponseDTO response = new ResponseDTO();
    	
    	logger.debug("Mensagem de Teste...");
    	
    	response.setCode(100);
    	response.setMessage("Teste...");
    	
        return response;
    }
}