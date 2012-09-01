package com.petrichor.extrack.domain;

public class AccountOwner extends User {

	private static final long serialVersionUID = -5780960983132025635L;

	private String screenName;
	private String firstName;
	private String middleName;
	private String lastName;

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

	@Override
	public String toString() {
		return String
				.format("AccountOwner [screenName=%s, firstName=%s, middleName=%s, lastName=%s, getAuthorities()=%s, getUsername()=%s, getPassword()=%s, isAccountNonExpired()=%s, isAccountNonLocked()=%s, isCredentialsNonExpired()=%s, isEnabled()=%s, getId()=%s]",
						screenName, firstName, middleName, lastName,
						getAuthorities(), getUsername(), getPassword(),
						isAccountNonExpired(), isAccountNonLocked(),
						isCredentialsNonExpired(), isEnabled(), getId());
	}

}
