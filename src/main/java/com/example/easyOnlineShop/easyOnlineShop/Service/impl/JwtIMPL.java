package com.example.easyOnlineShop.easyOnlineShop.Service.impl;

import com.example.easyOnlineShop.easyOnlineShop.Service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Transactional
public class JwtIMPL implements JwtService {

    private static final String SECRET_KEY="4B6V6HJ57V8JHV78V53J44L6B3L4B2LK2L24KB67V48C4HJ8CJC86JHC562652J54L43JL";

    @Override
    public String getToken(UserDetails newUser) {
        return getToken(new HashMap<>(),newUser);
    }

    @Override
    public String getUSernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUSernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }


    private Claims getAllClaims(String token){
        return  Jwts
                .parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public<T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token)
    {
        return getClaim(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails newUser) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .subject(newUser.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*8))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
