package com.Metron.DetectionAPI.filter;

import com.Metron.DetectionAPI.JWTUtility;
import com.Metron.DetectionAPI.enities.UserTable;
import com.Metron.DetectionAPI.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token =request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer ")){
            token=token.substring(7);
            Claims claims = JWTUtility.extractClaim(token);
            String userName = claims.getSubject();
            UserTable  userTable = userRepository.findByUserName(userName).get();
            if(JWTUtility.validate(claims,userTable)){
                UsernamePasswordAuthenticationToken AuthenticationToken = new UsernamePasswordAuthenticationToken(userTable, null , userTable.getAuthorities());
//                AuthenticationToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(AuthenticationToken);
            }
        }
   filterChain.doFilter(request,response);
    }
}
