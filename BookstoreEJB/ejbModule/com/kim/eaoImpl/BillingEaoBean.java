package com.kim.eaoImpl;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kim.eao.BillingEao;
import com.kim.model.Billing;

 
@Stateless
@Remote
@TransactionManagement(TransactionManagementType.CONTAINER)  
public class BillingEaoBean implements BillingEao {

	@PersistenceContext(unitName= "DS")
    private EntityManager em;
	
    public BillingEaoBean() {        
    }

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addBilling(Billing billing) {
		
		em.persist(billing);
		em.flush();	
	}

}
