package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.User;
import com.example.demo.service.ControllerService;


@Validated
@RestController
public class RESTController extends ResponseEntityExceptionHandler{

	@Autowired
	private ControllerService service;
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	return new ResponseEntity<>("no es valido: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String getString() {
		return service.getString();
	}
	
	
	@RequestMapping(value = "/userbyid/{id}", method = RequestMethod.GET)
	@ResponseBody
	@Valid
	public User findById(@PathVariable("id")int id) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println(request.toString());
		return service.findById(id);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public String findAll() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println(request.toString());
		return service.findAll();
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public User save(@RequestBody User user) {
		return service.save(user);
	}
	
		
	@RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public User deleteById(@PathVariable("id")int id) {
		return service.deleteById(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public User update(@RequestBody User user) {
		return service.save(user);
	}
}
