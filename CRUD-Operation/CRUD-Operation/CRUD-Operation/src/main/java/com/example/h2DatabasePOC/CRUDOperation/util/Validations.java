package com.example.h2DatabasePOC.CRUDOperation.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validations {

	public boolean isNullOrNegativeInput(int movieId) {
		if (movieId <= 0) {
			return true;
		}
		return false;

	}

	public boolean isUserNameValid(String userName) {

		Pattern pattern = Pattern.compile("[a-zA-Z]+(\\s+[a-zA-Z]+)*");

		String str = userName;
		Matcher matcher = pattern.matcher(str);

		if (!matcher.matches()) {
			return true;
		}
		return false;

	}

}
