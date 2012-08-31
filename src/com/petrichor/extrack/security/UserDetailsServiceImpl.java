package com.petrichor.extrack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.petrichor.extrack.dao.UserDAO;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDAO accountOwnerDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = accountOwnerDAO.findByUsername(username);
		
		if(userDetails == null) {
			throw new UsernameNotFoundException("User [" + username + "] does not exist.");
		}
		
		return userDetails;
	}

}
