package com.example.demo.ExceptionHandler;

public class UserNotFoundException extends RuntimeException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(int id) {
	      super(String.format("Usuario con Id " +id + " no encontrado", id));
	 }
	

}
