package com.ensas.miniprojet.demo.filters;

import com.ensas.miniprojet.demo.service.userService.MyUserDetailsService;
import com.ensas.miniprojet.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {



        if(!request.getRequestURI().equals("/authenticate"))
        {
            final String authorizationHeader = request.getHeader("Authorization");

            System.out.println("in the filter" + request.getRequestURI());

            String jwt = null;
            String username = null;

            //extract data from the token
            if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
                jwt = authorizationHeader.substring(7);
                System.out.println("JWT : #" + jwt + "#");
                username = jwtUtil.extractUsername(jwt);
                System.out.println("in the filter first if : " + username + " jwt : " + jwt);
            }

            //lead the userName from the db using the userDetailsService
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                System.out.println("in the filter seconde if");

                UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);
                if(jwtUtil.validateToken(jwt, userDetails)){
                    System.out.println("in the filter third if");

                    System.out.println("filter : " + userDetails);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    request.setAttribute("userName", username);
                }
            }
        }

        filterChain.doFilter(request, httpServletResponse);
    }
}
