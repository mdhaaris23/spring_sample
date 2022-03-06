package com.example.forms.training.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.forms.training.model.User;

public interface LoginRepo extends CrudRepository<User, String> {

}
