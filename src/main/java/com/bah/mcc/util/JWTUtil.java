package com.bah.mcc.util;

import com.bah.mcc.domain.Token;

public interface JWTUtil {
	public boolean verifyToken(String jwt_token);
	public String getScopes(String jwt_token) ;
	public Token createToken(String scopes) ;
}