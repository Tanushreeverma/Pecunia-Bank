package com.capgemini.accountmanagement.exception;

public class UserDefinedException extends RuntimeException { // Exception

	private static final long serialVersionUID = 1L;

	public UserDefinedException(String msg) {
		super(msg);
	}

}