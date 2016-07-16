package com.enshire.bagpool.filters;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.enshire.bagpool.security.Authorizer;


public class AuthorizationFilter implements Filter{
	public static Authorizer authorizer = new Authorizer();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(authorizer.authorize(request.getParameter("token_id")) == null){
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			response.flushBuffer();
		}			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
