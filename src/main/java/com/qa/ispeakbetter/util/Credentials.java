package com.qa.ispeakbetter.util;

public class Credentials {

	// valid username valid password

	String userName;
	String password;
	String confirmPass;
	String firstName;
	String lastName;
	String email;
	String mobileNumber;

	// Constructor

	public Credentials(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public Credentials(String firstName, String lastName, String email, String password, String confirmPass, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPass = confirmPass;
		this.mobileNumber = mobileNumber;
	}
	

	// Getter and Setters

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
