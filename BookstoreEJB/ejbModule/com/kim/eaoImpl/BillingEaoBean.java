package com.kim.eaoImpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kim.eao.BillingEao;
import com.kim.model.Billing;

 
@Stateless
@Remote
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
