package com.anudip.crud.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String msg) {
		super(msg);//user not found exception message
		
	}

	
}
