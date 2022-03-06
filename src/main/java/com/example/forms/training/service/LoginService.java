package com.example.forms.training.service;

import com.example.forms.training.dto.UserDTO;

public interface LoginService {

	public String loginUser(UserDTO user);
	public String registerUser(UserDTO user);
}
