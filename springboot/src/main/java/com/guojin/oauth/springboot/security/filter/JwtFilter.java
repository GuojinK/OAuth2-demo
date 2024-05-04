package com.guojin.oauth.springboot.security.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.guojin.oauth.springboot.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;




    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/login")){
            filterChain.doFilter(request,response);
        }else{
            String header = request.getHeader("Authorization");
            if(header != null && header.startsWith("Bearer ")){
                try {
                    String token  = header.substring("Bearer ".length()).trim();
                    // verify token, throw exception if invalidated
                    DecodedJWT decodedJWT = jwtUtils.isVerified(token);
                    String username = decodedJWT.getSubject();
                    // get user role
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,null,
                            null);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    filterChain.doFilter(request,response);
                } catch (Exception e) {
                    System.out.println("Failed");
                }

            }else{
                filterChain.doFilter(request,response);

            }

        }
    }
}
