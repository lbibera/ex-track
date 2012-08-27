package com.petrichor.extrack.service;

import com.petrichor.extrack.domain.AccountOwner;

public interface UserRegistrationService {

	/**
	 * registers a new account owner.
	 * adds the correct authorities to be assigned for a new account owner.
	 * sets the activation status of the user. (enabled, expired, etc..)
	 * ignores (and) overwrites the existing values mentioned above.
	 * @param accountOwner
	 * @throws ExTrackServiceException when the registration fails.
	 */
	void register(AccountOwner accountOwner) throws ExTrackServiceException;
	
}
