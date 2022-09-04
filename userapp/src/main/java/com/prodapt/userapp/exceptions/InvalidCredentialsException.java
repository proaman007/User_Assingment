package com.prodapt.userapp.exceptions;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvalidCredentialsException extends Exception{
	
	private String message;

	@Override
	public String toString() {
		return "InvalidCredentialsException [message=" + message + "]";
	}
	 
	
}
