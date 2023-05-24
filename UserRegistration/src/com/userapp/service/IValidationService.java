package com.userapp.service;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public interface IValidationService {
boolean validateUserName(String username) throws NameExistsException;
boolean ValidatePassword(String password) throws TooShortException, TooLongException;
}