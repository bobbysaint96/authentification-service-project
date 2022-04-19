package com.bah.mcc.api;

import org.springframework.web.client.RestTemplate;

import com.bah.mcc.domain.Customer;

public class Authenticator {

	public static boolean checkPassword(String username, String password) {

		if ((username != null && username.length() > 0) && (password != null && password.length() > 0)) {
			
			String customersAPIbase = "http://localhost:8080/api/customers/byname/" + username;
			RestTemplate template = new RestTemplate();
			Customer customer = template.getForObject(customersAPIbase, Customer.class);
			
			if (username.equals(customer.getName()) && password.equals(customer.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
