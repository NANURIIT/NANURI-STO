package com.nanuri.rams.com.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationLogoutSuccessHandler implements LogoutSuccessHandler {
	
	@Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                             Authentication authentication) throws IOException, ServletException {
        if (authentication != null && authentication.getDetails() != null) {

            try {
            	//세션 처리
                request.getSession().invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

		
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect("/login");
		
    }

}
