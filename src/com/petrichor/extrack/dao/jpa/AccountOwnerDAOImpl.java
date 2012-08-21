package com.petrichor.extrack.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.petrichor.extrack.dao.AccountOwnerDAO;
import com.petrichor.extrack.domain.AccountOwner;

@Repository("accountOwnerDAO")
public class AccountOwnerDAOImpl implements AccountOwnerDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean create(AccountOwner accountOwner) {
		em.persist(accountOwner);
		return true;
	}

	@Override
	public AccountOwner findByUsername(String username) {
		final String selectByUsername = "SELECT a FROM AccountOwner a WHERE a.username = :username";
		
		TypedQuery<AccountOwner> query = em.createQuery(selectByUsername, AccountOwner.class);
		query.setParameter("username", username);
		
		AccountOwner accountOwner = null;
		
		try {
			accountOwner = query.getSingleResult();
		} catch (NoResultException e) {
			
		} catch (NonUniqueResultException e) {
			accountOwner = query.getResultList().get(0);
		} 
		
		return accountOwner;
	}

}
