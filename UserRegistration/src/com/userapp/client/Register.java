package com.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.IValidationService;
import com.userapp.service.ValidateServiceImpl;

public class Register {

	public static void main(String[] args) {
		IValidationService validationservice = new ValidateServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name to register");
		String name = sc.nextLine();
		try
		{
		validationservice.validateUserName(name);
		}
		catch (NameExistsException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		
		System.out.println("enter the password");
		String password = sc.nextLine();
		try
		{
		validationservice.ValidatePassword(password);
		}
		catch (TooShortException | TooLongException e) {
			System.out.println(e.getMessage());
		}

	}

}
