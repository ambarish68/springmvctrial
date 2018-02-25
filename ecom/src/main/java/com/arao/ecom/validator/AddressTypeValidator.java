package com.arao.ecom.validator;

import com.arao.common.address.AddressType;
import com.arao.ecom.exception.BusinessLogicException;

public class AddressTypeValidator implements IValidator<AddressType>{

	public void validate(AddressType t) throws BusinessLogicException {
		if(t.getName()==null || t.getName().length()==0){
			throw new BusinessLogicException("Address Type Name cannot be null or empty");
		}
	}

}
