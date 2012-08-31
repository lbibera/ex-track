package com.petrichor.extrack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petrichor.extrack.dao.ExTrackUserDAO;
import com.petrichor.extrack.domain.AccountOwner;
import com.petrichor.extrack.domain.Authority;
import com.petrichor.extrack.service.ExTrackServiceException;
import com.petrichor.extrack.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private ExTrackUserDAO userDAO;

	@Override
	public void register(AccountOwner accountOwner) throws ExTrackServiceException {
		Authority roleUser = findOrCreate("ROLE_USER");
		Authority roleOwner = findOrCreate("ROLE_OWNER");

		accountOwner.addAuthority(roleUser);
		accountOwner.addAuthority(roleOwner);
		
		userDAO.create(accountOwner);
	}
	
	private Authority findOrCreate(String authority) {
		Authority auth = userDAO.findByAuthority(authority);
		
		if(auth == null) {
			Authority a = new Authority();
			a.setAuthority(authority);
			if(authority.equals("ROLE_USER")) {
				a.setDisplay("User");
			} else {
				a.setDisplay("Owner");
			}
			userDAO.create(a);
		}
		
		return userDAO.findByAuthority(authority);
	}

}
