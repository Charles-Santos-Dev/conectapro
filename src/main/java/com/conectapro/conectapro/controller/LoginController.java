package com.conectapro.conectapro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conectapro.conectapro.DTO.LoginRequestDTO;
import com.conectapro.conectapro.DTO.ResponseDTO;
import com.conectapro.conectapro.entity.UserEntity;
import com.conectapro.conectapro.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UserService userService;
    
	@PostMapping("/login")
    public ResponseDTO login(@RequestBody LoginRequestDTO user) {
    	
		List<UserEntity> users = this.userService.findAllUsers();
		
    	ResponseDTO response = new ResponseDTO();
    	
    	response.setCode(0);
    	response.setMessage("ok");
    	
        return response;
    }
}