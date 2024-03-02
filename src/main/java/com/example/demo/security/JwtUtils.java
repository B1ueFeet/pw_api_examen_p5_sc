package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {

	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.jwtSemilla}")
	private String jwtSemilla;

	@Value("${app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public boolean validateJwtToken(String auth) {

		try {
			Jwts.parser().setSigningKey(this.jwtSemilla).parseClaimsJws(auth);
			return true;
		} catch (Exception e) {
			LOG.error("ERROOOOOOORRRRR", e);
		}
		return false;
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(this.jwtSemilla).parseClaimsJws(token).getBody().getSubject();
	}

}
