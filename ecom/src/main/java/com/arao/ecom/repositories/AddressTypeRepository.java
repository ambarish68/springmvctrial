package com.arao.ecom.repositories;

import java.util.List;

import com.arao.common.address.AddressType;
import com.arao.ecom.exception.BusinessLogicException;
import com.arao.ecom.validator.AddressTypeValidator;

public class AddressTypeRepository extends GenericRepository<AddressType> {
	
private AddressTypeValidator addressTypeValidator=new AddressTypeValidator();
	
	@Override
	public List<AddressType> add(List<AddressType> addressTypes) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<addressTypes.size();i++){
			if(addressTypes.get(i).getAddressTypeId()==0){
				addressTypeValidator.validate(addressTypes.get(i));
				session.persist(addressTypes.get(i));
			}
		}
		session.getTransaction().commit();
		return addressTypes;
	}
	
	@Override
	public List<AddressType> update(List<AddressType> addressTypes) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<addressTypes.size();i++){
			if(addressTypes.get(i).getAddressTypeId()!=0){
				addressTypeValidator.validate(addressTypes.get(i));
				session.saveOrUpdate(addressTypes.get(i));
			}
		}
		session.getTransaction().commit();
		return addressTypes;
	}
	
	@Override
	public void delete(List<AddressType> addressTypes) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<addressTypes.size();i++){
			if(addressTypes.get(i).getAddressTypeId()!=0){
				session.delete(addressTypes.get(i));
			}
		}
		session.getTransaction().commit();
	}

}
