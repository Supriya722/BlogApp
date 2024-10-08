//package com.blogApp.blog.security;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.MalformedJwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtTokenHelper jwtTokenHelper;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        // Get token from the request header
//        String requestTokenHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String token = null;
//
//        // Check if the token is present and has the correct format
//        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//            token = requestTokenHeader.substring(7);
//            System.out.println("Token extracted: " + token);
//        }
//            try {
//                username = this.jwtTokenHelper.getUsernameFromToken(token);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Unable to get Jwt token: " + e.getMessage());
//            } catch (ExpiredJwtException e) {
//                System.out.println("Jwt token has expired: " + e.getMessage());
//            } catch (MalformedJwtException e) {
//                System.out.println("Invalid Jwt token: " + e.getMessage());
//            } catch (Exception e) {
//                System.out.println("Exception occurred while parsing token: " + e.getMessage());
//            }
//
//        // Once we get the token, now validate it
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//        	UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//        	System.out.println("UserDetails loaded: " + userDetails);
//
//            // If token is valid configure Spring Security to manually set authentication
//            if (this.jwtTokenHelper.validateToken(token, userDetails)) {
//
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
//                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                // Set the authentication in the context
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
//            } else {
//                System.out.println("Invalid Jwt token");
//            }
//        } else {
//            System.out.println("Username is null or context is not null");
//        }
//
//        filterChain.doFilter(request, response);
//        
//       }
//    }
