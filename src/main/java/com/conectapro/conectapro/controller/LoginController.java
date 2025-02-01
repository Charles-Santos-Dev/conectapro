package com.conectapro.conectapro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}