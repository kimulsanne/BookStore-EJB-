package com.kim.eao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kim.model.Billing;

 
@Stateless
@Local
public class BillingEaoBean implements BillingEao {

	@PersistenceContext(unitName= "DS")
    private EntityManager em;
	
    public BillingEaoBean() {        
    }

	@Override
	public void addBilling(Billing billing) {
		em.persist(billing);
		em.flush();	
		System.out.println("eao add");
	}

}
