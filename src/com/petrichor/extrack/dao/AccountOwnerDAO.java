package com.petrichor.extrack.dao;

import com.petrichor.extrack.domain.AccountOwner;

public interface AccountOwnerDAO {

	/**
	 * 
	 * @param accountOwner
	 * @return true if account was added.
	 */
	boolean create(AccountOwner accountOwner);

	/**
	 * return null if user is not found.
	 * assume username is unique if it exists.
	 * @param username
	 * @return
	 */
	AccountOwner findByUsername(String username);
	
}
