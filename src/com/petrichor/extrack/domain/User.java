package com.petrichor.extrack.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.google.appengine.api.datastore.Key;

/**
 * the base class for all authenticated users.
 * @author lyndon
 */
public class User implements UserDetails {

	private static final long serialVersionUID = -9081620973217780589L;
	
	private Key id;

	//authentication&authorization details
	private String username; //TODO: should be unique
	private String password;
	private boolean accountExpired = false;
	private boolean accountLocked = false;
	private boolean credentialsExpired = false;
	private boolean enabled = true;
	
	private Set<Authority> authorities = new HashSet<Authority>();
	
	public void setId(Key id) {
		this.id = id;
	}

	@Override
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public Key getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public void setCredentialsExpired(boolean credentialsNonExpired) {
		this.credentialsExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addAuthority(Authority authority) {
		authorities.add(authority);
	}
	
	public void removeAuthority(Authority authority) {
		authorities.remove(authority);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}
	
}
