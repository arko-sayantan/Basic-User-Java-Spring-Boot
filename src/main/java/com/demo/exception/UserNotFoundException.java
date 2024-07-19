package com.demo.exception;

import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(Long id){
		super("User not found with this id : " + id);
	}
}
