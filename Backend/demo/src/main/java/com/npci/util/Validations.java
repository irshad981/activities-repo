package com.npci.util;

import org.springframework.stereotype.Component;

import com.npci.exceptions.ValidationException;

@Component
public class Validations {
	
	public boolean checkForEmail(String email) throws ValidationException {
		if ((email.contains("@")) && (email.contains("."))) {
			return true;

		}
		throw new ValidationException("Sorry '.' or '@' is not found in " + email);

	}
	
	public boolean checkForFirstName(String name) throws ValidationException {
		if (name.length() >= 3 ) {
			return true;
		}
		throw new ValidationException("Sorry " + name + " sholud have more than or Equal to 3 charatcers");

	}
	
	public boolean checkForLastName(String name) throws ValidationException {
		if (name.length() >= 1) {
			return true;
		}
		throw new ValidationException("Sorry " + name + " sholud have more than or Equal to 1 characters");

	}
	
	
	public boolean checkForPassword(String password) throws ValidationException {
		if (password.length() < 8) {
			throw new ValidationException("Sorry " + password + " sholud have minimum 8 characters");
		}
		if (!(password.contains("1") || password.contains("#") || password.contains("!") || password.contains("~")
				|| password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&")
				|| password.contains("*") || password.contains("(") || password.contains(")") || password.contains("-")
				|| password.contains("+") || password.contains("/") || password.contains(":") || password.contains(".")
				|| password.contains(", ") || password.contains("<") || password.contains(">") || password.contains("?")
				|| password.contains("|"))) {
			throw new ValidationException("password should contains atleaste one special char or 1");
		}
		boolean d = false;
		boolean u = false;
		boolean l = false;
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isDigit(ch)) {
				d = true;

			}
			if (Character.isUpperCase(ch)) {
				u = true;

			}
			if (Character.isLowerCase(ch)) {
				l = true;

			}

		}
		if (d && u && l) {
			return true;
		}
		throw new ValidationException("password should contains atleast one lowercase,one uppercase,one digit or 1 digit as 1");

	}
	
	public boolean checkForPhoneNumber(Long phone) throws ValidationException {
		if (phone.toString().length() != 10) {

			throw new ValidationException("Sorry " + phone + " sholud have exact 10 digits");

		}
		return true;
	}
	
	public boolean checkForPan(String pan) throws ValidationException {
	    // Check if the PAN is required (not empty or null)
	    if (pan == null || pan.trim().isEmpty()) {
	        throw new ValidationException("PAN is required.");
	    }
	    
	    // Check if the PAN follows a specific format (e.g., 10 characters)
	    if (pan.length() != 10) {
	        throw new ValidationException("PAN should have exactly 10 characters.");
	    }
	    
	    // Additional PAN format checks can be added here if needed.

	    return true;
	}
	
	
	
	

}
