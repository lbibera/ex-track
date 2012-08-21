package com.petrichor.extrack.model;

import com.petrichor.extrack.domain.AccountOwner;

public class UserRegistrationForm {

	private String username;
	private String password;
	private String passwordConfirm;
	private String screenName;
	private String firstName;
	private String middleName;
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static AccountOwner createAccount(UserRegistrationForm form) {
		AccountOwner newOwner = new AccountOwner();
		
		newOwner.setUsername(form.getUsername());
		newOwner.setPassword(form.getPassword());
		newOwner.setFirstName(form.getFirstName());
		newOwner.setMiddleName(form.getMiddleName());
		newOwner.setLastName(form.getLastName());
		newOwner.setScreenName(form.getScreenName());
		newOwner.setEnabled(true);
		newOwner.setAccountExpired(false);
		newOwner.setCredentialsExpired(false);
		newOwner.setAccountLocked(false);
		
		return newOwner;
	}
}
