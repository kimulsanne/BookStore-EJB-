package com.kim.eaoImpl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.kim.eao.UserEao;
import com.kim.model.User;

/**
 * Session Bean implementation class UserEao
 */
@Stateless
@Remote
public class UserEaoBean implements UserEao {
	
	@PersistenceContext(unitName= "DS")
    private EntityManager em;
	
    public UserEaoBean() {
    }
    
	@Override
	public void addUser(User user)  {
		user.setRole("guest");
		em.persist(user);
		em.flush();
	}
	
	@Override
	public User getUser(String username) {
		Query query = em.createQuery(
				"select t from User t where t.username =:username").setParameter(
				"username", username);
		List list = query.getResultList();
		if (!list.isEmpty()) {
			return (User) list.get(0);
		}
		else {			
			return null;
		}
	}
	
	@Override
	public List<User> getAllUser() {
		Query query = em.createQuery(
				"select t from User t");
		List<User> list = query.getResultList();
		if (!list.isEmpty()) {
			return list;
		}
		else {			
			return null;
		}
	}

}
