package com.example.forms.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forms.training.dto.UserDTO;
import com.example.forms.training.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping(value="/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
		String response = loginService.loginUser(userDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
		String response = loginService.registerUser(userDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
