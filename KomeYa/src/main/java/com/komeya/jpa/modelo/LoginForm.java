package com.komeya.jpa.modelo;

public class LoginForm {
	
	private String email;
	private String pass;
	public LoginForm(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	
	public LoginForm() {
		super();
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
