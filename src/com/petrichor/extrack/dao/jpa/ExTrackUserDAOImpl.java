package com.petrichor.extrack.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.petrichor.extrack.dao.ExTrackDAOException;
import com.petrichor.extrack.dao.ExTrackUserDAO;
import com.petrichor.extrack.domain.AccountOwner;
import com.petrichor.extrack.domain.ExTrackAuthority;

@Repository
public class ExTrackUserDAOImpl implements ExTrackUserDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(ExTrackAuthority authority) throws ExTrackDAOException {
		em.persist(authority);
	}

	@Override
	public ExTrackAuthority findByAuthority(String authority) {
		final String selectByAuthority = String.format("SELECT a FROM %s a WHERE a.authority = :authority", ExTrackAuthority.class.getName());
		
		TypedQuery<ExTrackAuthority> query = em.createQuery(selectByAuthority, ExTrackAuthority.class);
		query.setParameter("authority", authority);
		
		ExTrackAuthority extrackAuthority = null;
		
		try {
			extrackAuthority = query.getSingleResult();
		} catch(NoResultException e) {
			
		} catch (NonUniqueResultException e) {
			extrackAuthority = query.getResultList().get(0);
		}
		
		return extrackAuthority;
	}

	@Override
	public void create(AccountOwner accountOwner) {
		em.persist(accountOwner);
	}

	@Override
	public AccountOwner findByUsername(String username) {
		final String selectByUsername = String.format("SELECT a FROM %s a WHERE a.username = :username", AccountOwner.class.getName());
		
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

	@Override
	public void update(AccountOwner accountOwner) {
		em.merge(accountOwner);
	}

}
