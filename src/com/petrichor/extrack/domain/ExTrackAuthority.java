package com.petrichor.extrack.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import com.google.appengine.api.datastore.Key;

@Entity
public class ExTrackAuthority implements GrantedAuthority {

	private static final long serialVersionUID = -5574670496359015664L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
	private String authority;
	private String display;

	public Key getId() {
		return id;
	}
	
	@Override
	public String getAuthority() {
		return authority;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authority == null) ? 0 : authority.hashCode());
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
		if (!(obj instanceof ExTrackAuthority)) {
			return false;
		}
		ExTrackAuthority other = (ExTrackAuthority) obj;
		if (authority == null) {
			if (other.authority != null) {
				return false;
			}
		} else if (!authority.equals(other.authority)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("ExTrackAuthority [%s]", authority);
	}
	
}
