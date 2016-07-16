package com.enshire.bagpool.security;

import java.util.Date;

public class Token {
	private String userName;
	private String token;
	private java.util.Date expiry;
	
	public Token() {
		super();
	}
	public Token(String userName, String token, Date expiry) {
		super();
		this.userName = userName;
		this.token = token;
		this.expiry = expiry;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public java.util.Date getExpiry() {
		return expiry;
	}
	public void setExpiry(java.util.Date expiry) {
		this.expiry = expiry;
	}
}
