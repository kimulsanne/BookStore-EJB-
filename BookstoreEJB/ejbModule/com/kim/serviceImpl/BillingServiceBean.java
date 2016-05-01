package com.kim.serviceImpl;


import javax.jms.*;
import javax.ejb.*;
import com.kim.eao.BillingEao;
import com.kim.model.Billing;

@MessageDriven(
		activationConfig = {
			@ActivationConfigProperty(propertyName="destination", propertyValue="queue/test"),
			@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue")
		},
		mappedName="queue/test")

public class BillingServiceBean implements MessageListener {

    @EJB
    private BillingEao billingEao;
    
    public BillingServiceBean() {
        
    }


	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("收到消息!");
			ObjectMessage message = (ObjectMessage)msg;			
			Billing billing = (Billing)message.getObject();
			if (billing != null)
				billingEao.addBilling(billing);		
			
		} catch (JMSException e) {			
			e.printStackTrace();
		}
		
	}

}
 