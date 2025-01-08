package com.ecommerce.auth.autil;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secret;

	// Validate user name in token and Database,expDate
	public Boolean ValidateToken(String token, String username) {
		String tokenusername = getUsername(token);
		return (username.equals(tokenusername) && !isTokenExp(token));

	}

	// Validate Exp Date
	public Boolean isTokenExp(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}

	// Read Subject
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	// Read Ex Date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}

	// read claims
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}

	// Generate TOken
	public String generateToken(String subject) {
		return Jwts.builder().setSubject(subject).setIssuer("Amazon").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}
}
