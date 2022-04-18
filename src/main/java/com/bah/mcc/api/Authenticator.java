package com.bah.mcc.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.client.RestTemplate;

import com.bah.mcc.domain.Customer;

public class Authenticator {
	
	
//	public static boolean checkUser(String username) {
//		String customersAPIbase="http://localhost:8080/byname/ " + username;
//		RestTemplate template = new RestTemplate();
//		Customer customer = template.getForObject(customersAPIbase, Customer.class);
//		
//		if( (username != null && username.length() > 0) &&
//			customer != null) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	
	public static boolean checkPassword(String username, String password) {
		String customersAPIbase="http://localhost:8080/api/customers/byname/" + username;
		RestTemplate template = new RestTemplate();
		Customer customer = template.getForObject(customersAPIbase, Customer.class);
		
		if (username.equals( customer.getName() ) && password.equals( customer.getPassword() )) {
			return true;
		}
		return false;
	}
	
}
