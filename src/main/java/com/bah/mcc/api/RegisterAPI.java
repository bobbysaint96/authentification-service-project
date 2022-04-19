package com.bah.mcc.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bah.mcc.domain.Customer;
import com.bah.mcc.util.JWTHelper;
import com.bah.mcc.util.JWTUtil;

@RestController
@RequestMapping("/register")
public class RegisterAPI {
	JWTUtil jwtUtil = new JWTHelper();
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer cust) {
		
		if (cust.getName() == null || cust.getEmail() == null || cust.getPassword() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		String customersAPIbase = "http://localhost:8080/api/customers/";
		RestTemplate template = new RestTemplate();
		Customer newCust = template.postForObject(customersAPIbase, cust, Customer.class);
		
		ResponseEntity<?> response = ResponseEntity.ok(newCust);
		return response;
		
	}
	
	
}
