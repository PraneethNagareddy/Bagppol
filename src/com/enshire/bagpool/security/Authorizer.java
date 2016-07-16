package com.enshire.bagpool.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


public class Authorizer {
	private Map<String, Token> tokenMap = new HashMap<String,Token>();
	
	public Authorizer(){
		tokenMap.put("praneeth", new Token("praneeth","praneeth",new java.util.Date(System.currentTimeMillis()+30*60*100)));
	}
	
	public void validateSession(HttpServletRequest request, HttpServletResponse response){
		System.out.println("PRANEETH");
		Token token = tokenMap.get(request.getParameter("token_id"));
		if(token == null){
			try {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			String uri = request.getRequestURI();
			System.out.println("Path:"+request.getServletPath());
		}
	}
	
	
	public String authorize(String tokenID){
		Token token = tokenMap.get(tokenID);
		if(token == null)
			return null;
		else {
			token.getExpiry().setMinutes(token.getExpiry().getMinutes()+30);
			return token.getUserName();
		}
	}
	
	public String storeSession(String userName){
		if(userName.equals("dummy"))
			return "dummy";
		tokenMap.put(userName, new Token(userName,userName,new java.util.Date(System.currentTimeMillis()+30*60*100)));
		return userName;
	}
	
	public void serialize(){
		
	}
	
	public void deSerialize(){
		
	}
}
