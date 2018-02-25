package com.arao.ecom.validator;

import com.arao.common.payment.PaymentMethod;
import com.arao.ecom.exception.BusinessLogicException;

public class PaymentMethodValidator implements IValidator<PaymentMethod>{

	public void validate(PaymentMethod t) throws BusinessLogicException {
		if(t.getName()==null || t.getName().length()==0){
			throw new BusinessLogicException("Payment method name cannot be null or empty");
		}
		if(t.getDescription()==null || t.getDescription().length()==0){
			throw new BusinessLogicException("Payment method Description cannot be null or empty");
		}
	}

}
