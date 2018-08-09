package com.marc2web.springsecurity.components;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.marc2web.springsecurity.dto.ROLES;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
			Collection<?extends GrantedAuthority>	authorities= authentication.getAuthorities();
			
			System.err.println(authorities.size());
			authorities.forEach(authority ->{
				
				System.err.println("=------------i am here -------"+authority);
				if(authority.getAuthority().equals(ROLES.ROLE_USER.toString())) {
					try {
						redirectStrategy.sendRedirect(request, response, "/user/index");
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				else if(authority.getAuthority().equals(ROLES.ROLE_SUPER_USER.toString())) {
					try {
						redirectStrategy.sendRedirect(request, response, "/adminstrator/index");
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				else if (authority.getAuthority().equals(ROLES.ROLE_ADMIN.toString()) ) {
					try {
						redirectStrategy.sendRedirect(request, response, "/admin/index");
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			});
		
		
	}
}
