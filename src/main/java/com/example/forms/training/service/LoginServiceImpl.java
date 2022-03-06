package com.example.forms.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.training.dto.UserDTO;
import com.example.forms.training.model.User;
import com.example.forms.training.repo.LoginRepo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepo loginRepository;

	@Override
	public String loginUser(UserDTO user) {
		Optional<User> userFromDB = loginRepository.findById(user.getUserId());
		return userFromDB.isPresent() ? "Hi " + user.getUserName() + " , You are logged in"
				: "Sorry! invalid user id or password";

	}

	@Override
	public String registerUser(UserDTO user) {
		Optional<User> userFromDB = loginRepository.findById(user.getUserId());
		if (userFromDB.isPresent()) {
			return "Oops! User Id already exists!!";
		}
		loginRepository.save(new User(user.getUserName(), user.getUserId(), user.getPassword()));
		return "You have successfully registered!!";
	}

}
