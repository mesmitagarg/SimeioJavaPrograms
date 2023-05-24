package com.userapp.service;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public class ValidateServiceImpl implements IValidationService{

	@Override
	public boolean validateUserName(String name) throws NameExistsException {
		String[] usernames = {"smita", "hareesha","neha"};
		for (String username:usernames) {
			if (name.equals(username)) throw new NameExistsException("Name already exists");
		}
		return false;
		/*if (found) System.out.println("Name is not unique");
		else System.out.println("You are Registered");*/
	}

	@Override
	public boolean ValidatePassword(String password) throws TooShortException, TooLongException {
		if (password.length()<6) throw new TooShortException("password is too short");
		if (password.length()>15) 
			throw new TooLongException("password is too long");
		else return true; 
	}

}
