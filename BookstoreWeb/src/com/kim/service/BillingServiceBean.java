package com.kim.service;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.kim.eao.BillingEao;
import com.kim.model.Billing;

 
@Stateless
@Local
public class BillingServiceBean implements BillingService {

    @EJB
    private BillingEao billingEao;
    
    public BillingServiceBean() {
        
    }

	@Override
	public void addBilling(Billing billing) {
		billingEao.addBilling(billing);
	}

}
