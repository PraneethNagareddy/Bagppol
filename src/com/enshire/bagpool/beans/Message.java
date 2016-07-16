package com.enshire.bagpool.beans;

import java.util.Date;

public class Message {
	private String to;
	private String from;
	private String message;
	private java.util.Date sentDate;
	
	public Message(String to, String from, String message, Date sentDate) {
		super();
		this.to = to;
		this.from = from;
		this.message = message;
		this.sentDate = sentDate;
	}

	public Message() {
		super();
	}


	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public java.util.Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(java.util.Date sentDate) {
		this.sentDate = sentDate;
	}
	
	
	
}
