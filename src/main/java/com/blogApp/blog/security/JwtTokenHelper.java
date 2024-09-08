//package com.blogApp.blog.security;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.SignatureException;
//import io.jsonwebtoken.MalformedJwtException;
//
//@Component
//public class JwtTokenHelper {
//
//    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//    private String secret = "JwtTokenKey"; // Ensure this matches your token generation key
//
//    // retrieve username from jwt token
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    // retrieve expiration date from jwt token
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    // for retrieving any info from token we will need secret key
//    private Claims getAllClaimsFromToken(String token) {
//        try {
//            return Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (SignatureException e) {
//            System.out.println("Invalid JWT signature: " + e.getMessage());
//            throw e;
//        } catch (MalformedJwtException e) {
//            System.out.println("Invalid JWT token: " + e.getMessage());
//            throw e;
//        } catch (ExpiredJwtException e) {
//            System.out.println("JWT token has expired: " + e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            System.out.println("Error parsing JWT token: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    // check if token has expired
//    private boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    // generate token for user
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return doGenerateToken(claims, userDetails.getUsername());
//    }
//
//    // while creating token define claims of the token
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    // validate token
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        try {
//            final String username = getUsernameFromToken(token);
//            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//        } catch (Exception e) {
//            System.out.println("JWT token validation error: " + e.getMessage());
//            return false;
//        }
//    }
//}
