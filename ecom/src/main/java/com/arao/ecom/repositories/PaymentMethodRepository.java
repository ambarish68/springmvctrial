package com.arao.ecom.repositories;

import java.util.List;
import com.arao.common.payment.PaymentMethod;
import com.arao.ecom.exception.BusinessLogicException;
import com.arao.ecom.validator.PaymentMethodValidator;

public class PaymentMethodRepository extends GenericRepository<PaymentMethod>{
	
	private PaymentMethodValidator paymentMethodValidator=new PaymentMethodValidator();
	
	@Override
	public List<PaymentMethod> add(List<PaymentMethod> paymentMethods) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<paymentMethods.size();i++){
			if(paymentMethods.get(i).getPaymentMethodId()==0){
				paymentMethodValidator.validate(paymentMethods.get(i));
				session.persist(paymentMethods.get(i));
			}
		}
		session.getTransaction().commit();
		return paymentMethods;
	}
	
	@Override
	public List<PaymentMethod> update(List<PaymentMethod> paymentMethods) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<paymentMethods.size();i++){
			if(paymentMethods.get(i).getPaymentMethodId()!=0){
				paymentMethodValidator.validate(paymentMethods.get(i));
				session.saveOrUpdate(paymentMethods.get(i));
			}
		}
		session.getTransaction().commit();
		return paymentMethods;
	}
	
	@Override
	public void delete(List<PaymentMethod> paymentMethods) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<paymentMethods.size();i++){
			if(paymentMethods.get(i).getPaymentMethodId()!=0){
				session.delete(paymentMethods.get(i));
			}
		}
		session.getTransaction().commit();
	}
}
