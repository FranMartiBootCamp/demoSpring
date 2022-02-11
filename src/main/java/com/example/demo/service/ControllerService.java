package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.ExceptionHandler.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

@Service
public class ControllerService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${course.message: Hellow World por defecto}")
	private String value; 
	
	public String getString() {
		return value;
	}
	
	@ApiOperation("Prueba")
	public String findAll() {
		String sUsers = "";
		for(User u: userRepository.findAll()) {
	    	sUsers = sUsers + u.toString();
	    }
		return sUsers;
	}
	
	public User findById(int id) {
		User user = userRepository.findById(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		return user;	
	}
	
	public User save(User user) {
		return userRepository.save(user);		
	}
	
	public User deleteById(int id) {
		return userRepository.deleteById(id);
	}
	
}
