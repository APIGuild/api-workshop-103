package com.tw.apiguild.config;

import com.tw.apiguild.constant.ApplicationConstants;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.tw.apiguild.constant.ApplicationConstants.HEADER_STRING;
import static com.tw.apiguild.constant.ApplicationConstants.TOKEN_PREFIX;
import static org.springframework.util.StringUtils.hasText;

public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(HEADER_STRING);
        if (!hasText(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return ;
        }

        //TODO: implement simple jwt validation
        chain.doFilter(request, response);

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().contains("jwt");
    }
}
