package cn.edu.bjut.librarymanagementsystem.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {
    private Key key;
    private long expirationMs;

    public JWTUtil(@Value("${app.jwt.secret}") String secret,
                  @Value("${app.jwt.expiration-ms}") long expirationMs) {
        // secret 长度至少 32 字节以便 HS256
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }

    public String generateToken(int userId, String loginName) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .setSubject(Integer.toString(userId))
                .claim("loginName", loginName)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }
}