package com.bah.mcc.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.mcc.domain.Customer;
import com.bah.mcc.domain.Token;
import com.bah.mcc.util.JWTHelper;
import com.bah.mcc.util.JWTUtil;

@RestController
@RequestMapping("/token")
public class TokenAPI {
	JWTUtil jwtUtil = new JWTHelper();
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> getToken(@RequestBody Customer customer) {
		
		String username = customer.getName();
		String password = customer.getPassword();

		
		if (username != null && username.length() > 0 
				&& password != null && password.length() > 0 
				&& Authenticator.checkPassword(username, password)) {
			Token token = jwtUtil.createToken(username);
			ResponseEntity<?> response = ResponseEntity.ok(token);
			return response;			
		}
		// bad request
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	
	
}
