package com.petrichor.extrack.dao;

import com.petrichor.extrack.domain.AccountOwner;
import com.petrichor.extrack.domain.ExTrackAuthority;
import com.petrichor.extrack.domain.ExTrackUser;

/**
 * responsible for retrieving and updating user-related objects.
 * this includes {@link ExTrackUser} and {@link ExTrackAuthority} as
 * well as its descendants. 
 * @author lyndon
 */
public interface ExTrackUserDAO {

	/**
	 * creates a new authority
	 * @param authority
	 * @throws ExTrackDAOException when creation fails
	 */
	void create(ExTrackAuthority authority) throws ExTrackDAOException;
	
	/**
	 * 
	 * @param authority
	 * @return
	 */
	ExTrackAuthority findByAuthority(String authority);
	
	/**
	 * 
	 * @param accountOwner
	 * @return true if account was added.
	 */
	void create(AccountOwner accountOwner);

	/**
	 * return null if user is not found.
	 * assume username is unique if it exists.
	 * @param username
	 * @return
	 */
	AccountOwner findByUsername(String username);
	
	void update(AccountOwner accountOwner);
	
}
