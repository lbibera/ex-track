package com.petrichor.extrack.dao.gae;

import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.petrichor.extrack.dao.ExTrackDAOException;
import com.petrichor.extrack.dao.UserDAO;
import com.petrichor.extrack.domain.AccountOwner;
import com.petrichor.extrack.domain.Authority;
import com.petrichor.extrack.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();

	@Override
	public void create(Authority authority) throws ExTrackDAOException {
		Entity authorityEntity = new Entity(Authority.class.getSimpleName());
		copyFields(authority, authorityEntity);
		
		Key key = dataStore.put(authorityEntity);
		authority.setId(key);
	}

	@Override
	public Authority findByAuthority(String authority) {
		Authority exTrackAuthority = null;
		
		Query q = new Query(Authority.class.getSimpleName());
		q.setFilter(new Query.FilterPredicate("authority_caseinsensitive", Query.FilterOperator.EQUAL, authority.toUpperCase()));
		PreparedQuery pq = dataStore.prepare(q);
		
		Entity e = pq.asSingleEntity();
		
		if(e != null) {
			exTrackAuthority = new Authority();
			copyFields(e, exTrackAuthority);
			exTrackAuthority.setId(e.getKey());
		}
		
		return exTrackAuthority;
	}

	@Override
	public void create(AccountOwner accountOwner) {
		Entity accountOwnerEntity = new Entity(AccountOwner.class.getSimpleName());
		copyFields(accountOwner, accountOwnerEntity);
		
		accountOwner.setId(dataStore.put(accountOwnerEntity));

		for(Authority a : accountOwner.getAuthorities()) {
			Entity mapper = new Entity(User.class.getSimpleName()+"_authorities");
			
			mapper.setProperty(User.class.getSimpleName() + "_id", accountOwner.getId());
			mapper.setProperty(Authority.class.getSimpleName() + "_id", a.getId());
			
			dataStore.put(mapper);
		}
	}

	@Override
	public AccountOwner findByUsername(String username) {
		AccountOwner accountOwner = null;
		
		Query q = new Query(AccountOwner.class.getSimpleName());
		q.setFilter(new Query.FilterPredicate("username", Query.FilterOperator.EQUAL, username));
		PreparedQuery pq = dataStore.prepare(q);
		
		Entity accountOwnerEntity = pq.asSingleEntity();
		
		if(accountOwnerEntity != null) {
			accountOwner = new AccountOwner();
			copyFields(accountOwnerEntity, accountOwner);
			accountOwner.setId(accountOwnerEntity.getKey());
			
			q = new Query(User.class.getSimpleName()+"_authorities");
			q.setFilter(new Query.FilterPredicate(User.class.getSimpleName() + "_id", Query.FilterOperator.EQUAL, accountOwner.getId()));
			pq = dataStore.prepare(q);
			
			for(Entity mapper : pq.asIterable()) {
				Authority authority = new Authority();
				
				Entity authorityEntity;
				try {
					authorityEntity = dataStore.get((Key) mapper.getProperty(Authority.class.getSimpleName() + "_id"));
					copyFields(authorityEntity, authority);
					authority.setId(authorityEntity.getKey());
					accountOwner.addAuthority(authority);
				} catch (EntityNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		return accountOwner;
	}

	@Override
	public void update(AccountOwner accountOwner) {
		Entity accountOwnerEntity = new Entity(accountOwner.getId());
		copyFields(accountOwner, accountOwnerEntity);
		//TODO: update roles
		dataStore.put(accountOwnerEntity);
	}
	
	private void copyFields(Entity source, Authority destination) {
		destination.setAuthority((String) source.getProperty("authority"));
		destination.setDisplay((String) source.getProperty("display"));
	}
	
	private void copyFields(Authority source, Entity destination) {
		destination.setProperty("authority", source.getAuthority());
		destination.setProperty("authority_caseinsensitive", source.getAuthority().toUpperCase()); //case-insensitive index
		destination.setProperty("display", source.getDisplay());
	}

	private void copyFields(Entity source, AccountOwner destination) {
		destination.setUsername((String) source.getProperty("username"));
		destination.setPassword((String) source.getProperty("password"));
		destination.setAccountExpired((Boolean) source.getProperty("accountExpired"));
		destination.setAccountLocked((Boolean) source.getProperty("accountLocked"));
		destination.setCredentialsExpired((Boolean) source.getProperty("credentialsExpired"));
		destination.setEnabled((Boolean) source.getProperty("enabled"));
		destination.setScreenName((String) source.getProperty("screenName"));
		destination.setFirstName((String) source.getProperty("firstName"));
		destination.setMiddleName((String) source.getProperty("middleName"));
		destination.setLastName((String) source.getProperty("lastName"));
	}
	
	private void copyFields(AccountOwner source, Entity destination) {
		destination.setProperty("username", source.getUsername());
		destination.setProperty("password", source.getPassword());
		destination.setProperty("accountExpired", !source.isAccountNonExpired());
		destination.setProperty("accountLocked", !source.isAccountNonLocked());
		destination.setProperty("credentialsExpired", !source.isCredentialsNonExpired());
		destination.setProperty("enabled", source.isEnabled());
		destination.setProperty("screenName", source.getScreenName());
		destination.setProperty("firstName", source.getFirstName());
		destination.setProperty("middleName", source.getMiddleName());
		destination.setProperty("lastName", source.getLastName());
	}
}
