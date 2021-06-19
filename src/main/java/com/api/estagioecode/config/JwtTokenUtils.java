package com.api.estagioecode.config;

import com.api.estagioecode.model.User;
import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtTokenUtils implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    /**
     * Retorna o username do token
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Para retornar qualquer informação do token nos iremos precisar da secretkey
     * @param token
     * @return
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * Cria o token e define tempo de expiração para ele
     * @param claims
     * @param subject
     * @return
     */
    private String doGenerateToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date((System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validateToken(String token, User userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getEmail()) && !isTokenExpired(token));
    }
}
