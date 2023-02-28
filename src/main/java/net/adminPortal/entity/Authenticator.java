package net.adminPortal.entity;

public class Authenticator {
	
	private String message;
	
	public Authenticator(String message) {this.message = message;}
	
	public String getMessage( ) {return message; }
	
	public void setMessage(String message) {this.message = message;}
	
	@Override
	public String toString() {return String.format("Welcome to the AdmiPortal [message=%s]", message);}
}
