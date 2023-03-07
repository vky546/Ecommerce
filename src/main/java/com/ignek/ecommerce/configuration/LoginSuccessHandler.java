package com.ignek.ecommerce.configuration;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.ignek.ecommerce.model.CustomUserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String email = userDetails.getEmail();
         
        String redirectURL = request.getContextPath();
         
        if (email.equals("admin@gmail.com")) {
            redirectURL = "/admin";
        } else{
            redirectURL = "/";
        }
         
        response.sendRedirect(redirectURL);
         
    }

}
